package com.bolife.blog.conntroller.home;

import com.alibaba.fastjson.JSON;
import com.bolife.blog.entity.*;
import com.bolife.blog.enums.EnArticleStatus;
import com.bolife.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired(required = false)
    private CategoryService categoryService;

    @Autowired(required = false)
    private ArticleTagRefService articleTagRefService;

    @Autowired(required = false)
    private ArticleCategoryRefService articleCategoryRefService;
    @RequestMapping("/article/{aid}")
    public String getArticleInfo(@PathVariable("aid")Integer aid, Model model){
        //文章信息，分类，标签，作者，评论
        Article articleByStatusAndId = articleService.getArticleByStatusAndId(EnArticleStatus.PUBLISH.getValue(), aid);
        if (articleByStatusAndId == null){
            return "redirect:/404";
        }
        //获取文章分类
        List<Category> categories = articleCategoryRefService.listCategoryByArticleId(aid);
        articleByStatusAndId.setCategoryList(categories);
        //获取文章标签
        List<Tag> tags = articleTagRefService.listTagByArticleId(aid);
        articleByStatusAndId.setTagList(tags);
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

    @RequestMapping(value = "/map")
    public String siteMap(Model model) {
        //文章显示
        List<Article> articleList = articleService.listAllNotWithContent();
        model.addAttribute("articleList", articleList);
        //分类显示
        List<Category> categoryList = categoryService.listCategory();
        model.addAttribute("categoryList", categoryList);
        //标签显示
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList", tagList);

        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(10);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/siteMap";
    }

    @RequestMapping(value = "/article/like/{articleId}",method = {RequestMethod.POST})
    @ResponseBody
    public String increaseLikeCount(@PathVariable("articleId") Integer articleId){
        Article article = articleService.getArticleByStatusAndId(EnArticleStatus.PUBLISH.getValue(), articleId);
        Integer articleLikeCount = article.getArticleLikeCount()+1;
        article.setArticleLikeCount(articleLikeCount);
        articleService.updateArticle(article);
        return JSON.toJSONString(articleLikeCount);
    }

    @RequestMapping(value = "/article/view/{id}", method = {RequestMethod.POST})
    @ResponseBody
    public String increaseViewCount(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleByStatusAndId(EnArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleViewCount() + 1;
        article.setArticleViewCount(articleCount);
        articleService.updateArticle(article);
        return JSON.toJSONString(articleCount);
    }
}
