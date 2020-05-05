package com.bolife.blog.conntroller.home;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Comment;
import com.bolife.blog.entity.Tag;
import com.bolife.blog.entity.User;
import com.bolife.blog.enums.EnArticleStatus;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.CommentService;
import com.bolife.blog.service.TagService;
import com.bolife.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 17:22
 * @Description:
 */
@Controller
public class ArticleController {
    @Autowired(required = false)
    private ArticleService articleService;

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private CommentService commentService;

    @Autowired(required = false)
    private TagService tagService;

    @RequestMapping("/article/{aid}")
    public String getArticleInfo(@PathVariable("aid")Integer aid, Model model){
        //文章信息，分类，标签，作者，评论
        Article articleByStatusAndId = articleService.getArticleByStatusAndId(EnArticleStatus.PUBLISH.getValue(), aid);
        if (articleByStatusAndId == null){
            return "redirect:/404";
        }
        //获取用户信息
        User user = userService.getUserById(articleByStatusAndId.getArticleUserId());
        articleByStatusAndId.setUser(user);
        //设置文章信息
        model.addAttribute("article",articleByStatusAndId);
        //评论列表
        List<Comment> comments = commentService.listCommentByArticleId(aid);
        model.addAttribute("comments",comments);
        //相关文章
        List<Integer> categoryIds = articleService.listCategoryIdByArticleId(aid);
        List<Article> similarArticleList = articleService.listArticleByCategoryIds(categoryIds, 5);
        model.addAttribute("similarArticleList", similarArticleList);

        //猜你喜欢
        List<Article> mostViewArticleList = articleService.listArticleByViewCount(5);
        model.addAttribute("mostViewArticleList", mostViewArticleList);

        //获取下一篇文章
        Article afterArticle = articleService.getAfterArticle(aid);
        model.addAttribute("afterArticle", afterArticle);

        //获取上一篇文章
        Article preArticle = articleService.getPreArticle(aid);
        model.addAttribute("preArticle", preArticle);

        //侧边栏
        //标签列表显示
        List<Tag> allTagList = tagService.listTag();
        model.addAttribute("allTagList", allTagList);
        //获得随机文章
        List<Article> randomArticleList = articleService.listRandomArticle(8);
        model.addAttribute("randomArticleList", randomArticleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);

        return "Home/Page/articleDetail";
    }
}
