package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.entity.Tag;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/3 16:16
 * @Description:
 */
@Controller
@SuppressWarnings("all")
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/tag/{tid}")
    public String goCategory(@PathVariable("tid") Integer tid,
                             @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             Model model){
        Tag tag = tagService.getTagById(tid);
        Map<String,Object> data = new HashMap<>();
        data.put("tagId",tid);
        PageInfo<Article> allArticle = articleService.getAllArticle(pageIndex, pageSize, data);
        List<Tag> allTag = tagService.getAllTag();
        List<Article> articleByComment = articleService.getArticleByComment(5);
        List<Article> articleByRandom = articleService.getArticleByRandom(5);
        model.addAttribute("randomArticleList",articleByRandom);
        model.addAttribute("mostCommentArticleList",articleByComment);
        model.addAttribute("allTagList",allTag);
        model.addAttribute("pageInfo",allArticle);
        model.addAttribute("tag",tag);
        model.addAttribute("pageUrlPrefix", "/tag/"+pageIndex+"?pageIndex");
        return  "Home/Page/articleListByTag";
    }
}
