package com.bolife.blog.conntroller.home;

import cn.hutool.http.HtmlUtil;
import com.bolife.blog.dto.JsonResult;
import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Comment;
import com.bolife.blog.entity.User;
import com.bolife.blog.enums.EnArticleStatus;
import com.bolife.blog.enums.EnRole;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.CommentService;
import com.bolife.blog.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 16:00
 * @Description:
 */
@Controller
@RestController
public class CommentController {

    @Autowired(required = false)
    private CommentService commentService;

    @Autowired(required = false)
    private ArticleService articleService;

    @RequestMapping(value = "/comment",method = {RequestMethod.POST})
    public JsonResult commitComment(HttpServletRequest request, Comment comment){
        //添加评论
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(MyUtils.getIpAddr(request));
        Article article = articleService.getArticleByStatusAndId(EnArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
        if (request.getSession().getAttribute("user") != null &&
                article.getArticleUserId().equals(comment.getCommentUserId())){
            User user = (User) request.getSession().getAttribute("user");
            comment.setCommentUserId(user.getUserId());
            comment.setCommentRole(EnRole.ADMIN.getValue());
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if(user != null)
                comment.setCommentUserId(user.getUserId());
            comment.setCommentRole(EnRole.VISITOR.getValue());
        }
        comment.setCommentAuthorAvatar(MyUtils.getGravatar(comment.getCommentAuthorEmail()));

        //过滤字符，防止XSS攻击
        comment.setCommentContent(HtmlUtil.escape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtil.escape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtil.escape(comment.getCommentAuthorEmail()));
        comment.setCommentAuthorUrl(HtmlUtil.escape(comment.getCommentAuthorUrl()));
        try {
            commentService.insertComment(comment);
            //更新文章的评论数
            articleService.updateCommentCount(article.getArticleId());
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult().fail();
        }
        return new JsonResult<>().ok();
    }
}
