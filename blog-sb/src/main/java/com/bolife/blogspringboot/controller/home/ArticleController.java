package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.entity.*;
import com.bolife.blogspringboot.service.*;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/3 14:39
 * @Description:
 */
@Controller
@SuppressWarnings("all")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @RequestMapping("/article/{aid}")
    public String goArticle(@PathVariable("aid")Integer aid, Model model){
        Article articleById = articleService.getArticleById(aid);
        User userById = userService.getUserById(articleById.getArticleUserId());
        articleById.setUser(userById);
        List<Article> articleByComment = articleService.getArticleByComment(5);
        List<Article> articleByRandom = articleService.getArticleByRandom(5);
        List<Tag> allTag = tagService.getAllTag();
        List<Category> categoiesByArticleId = categoryService.getCategoiesByArticleId(aid);
        articleById.setCategoryList(categoiesByArticleId);
        List<Tag> tagsByArticleId = tagService.getTagsByArticleId(aid);
        articleById.setTagList(tagsByArticleId);
        List<Article> articlesByCategories = articleService.getArticlesByCategories(categoiesByArticleId, 3);
        List<Article> articleByViewCount = articleService.getArticleByViewCount(3);
        Article afterArticle = articleService.getAfterArticle(aid);
        Article beforeArticle = articleService.getBeforeArticle(aid);
        List<Comment> commentByArticleId = commentService.getCommentByArticleId(aid);
        model.addAttribute("commentList",commentByArticleId);
        model.addAttribute("preArticle",beforeArticle);
        model.addAttribute("afterArticle",afterArticle);
        model.addAttribute("mostViewArticleList",articleByViewCount);
        model.addAttribute("similarArticleList",articlesByCategories);
        model.addAttribute("randomArticleList",articleByRandom);
        model.addAttribute("mostCommentArticleList",articleByComment);
        model.addAttribute("allTagList",allTag);
        model.addAttribute("article",articleById);
        return  "Home/Page/articleDetail";
    }

    @RequestMapping(value = "/article/view/{aid}",method = RequestMethod.POST)
    @ResponseBody
    public String viewCount(@PathVariable("aid")Integer aid){
        Article articleById = articleService.getArticleById(aid);
        articleById.setArticleViewCount(articleById.getArticleViewCount()+1);
        articleService.updateArticle(articleById);
        return new JSONObject(articleById.getArticleViewCount()+1).toString();
    }

    @RequestMapping("/search")
    public String search(
            @RequestParam("keywords") String keywords,
            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
        //文章列表
        Map<String,Object> data = new HashMap<>();
        data.put("keywords",keywords);
        PageInfo<Article> allArticle = articleService.getAllArticle(pageIndex, pageSize, data);
        model.addAttribute("pageInfo",allArticle);
        //侧边栏显示
        //标签列表显示
        List<Tag> allTagList = tagService.getAllTag();
        model.addAttribute("allTagList", allTagList);
        //获得随机文章
        List<Article> randomArticleList = articleService.getArticleByRandom(5);
        model.addAttribute("randomArticleList", randomArticleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.getArticleByComment(5);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        //最新评论
        List<Comment> recentCommentList = commentService.getNearComment(5);
        model.addAttribute("recentCommentList", recentCommentList);
        model.addAttribute("pageUrlPrefix", "/search?pageIndex");
        return "Home/Page/search";
    }

    @RequestMapping(value = "/article/like/{aid}",method = RequestMethod.POST)
    @ResponseBody
    public String likeArticle(@PathVariable("aid")Integer aid){
        Article articleById = articleService.getArticleById(aid);
        articleById.setArticleLikeCount(articleById.getArticleLikeCount()+1);
        articleService.updateArticle(articleById);
        return new JSONObject(articleById.getArticleLikeCount()+1).toString();
    }

    @RequestMapping("/article/file")
    public String articleFile(Model model) {
        List<Article> articleList = articleService.getArticle();
        model.addAttribute("articleList", articleList);
        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.getArticleByComment(10);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/articleFile";
    }
}
