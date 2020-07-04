package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.dto.JsonResult;
import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Comment;
import com.bolife.blogspringboot.entity.User;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.CommentService;
import com.bolife.blogspringboot.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/4 14:51
 * @Description:
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult commitComment(HttpServletRequest request, Comment comment){
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(MyUtils.getIpAddr(request));
        Article article = articleService.getArticleById(comment.getCommentArticleId());
        comment.setCommentRole(0);
        User user = (User) request.getSession().getAttribute("user");
        if ( user != null){
            comment.setCommentUserId(user.getUserId());
            if (article.getArticleUserId().equals(comment.getCommentUserId())){
                comment.setCommentRole(1);
            }
        }
        comment.setCommentAuthorAvatar(MyUtils.getGravatar(comment.getCommentAuthorEmail()));
        //过滤字符，防止XSS攻击
        comment.setCommentContent(HtmlUtils.htmlEscape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtils.htmlEscape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtils.htmlEscape(comment.getCommentAuthorEmail()));
        comment.setCommentAuthorUrl(HtmlUtils.htmlEscape(comment.getCommentAuthorUrl()));
        try {
            commentService.insertComment(comment);
            //更新文章的评论数
            article.setArticleCommentCount(article.getArticleCommentCount()+1);
            articleService.updateArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult().fail();
        }
        return new JsonResult<>().ok();
    }
}
