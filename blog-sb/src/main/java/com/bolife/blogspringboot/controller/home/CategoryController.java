package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.entity.Tag;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.CategoryService;
import com.bolife.blogspringboot.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/3 11:14
 * @Description:
 */
@Controller
public class CategoryController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @RequestMapping("/category/{cid}")
    public String goCategory(@PathVariable("cid") Integer cid,
                             @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             Model model){
        Category categoryById = categoryService.getCategoryById(cid);
        Map<String,Object> data = new HashMap<>();
        data.put("categoryId",cid);
        PageInfo<Article> allArticle = articleService.getAllArticle(pageIndex, pageSize, data);
        List<Tag> allTag = tagService.getAllTag();
        List<Article> articleByComment = articleService.getArticleByComment(5);
        List<Article> articleByRandom = articleService.getArticleByRandom(5);
        model.addAttribute("randomArticleList",articleByRandom);
        model.addAttribute("mostCommentArticleList",articleByComment);
        model.addAttribute("allTagList",allTag);
        model.addAttribute("pageInfo",allArticle);
        model.addAttribute("category",categoryById);
        model.addAttribute("pageUrlPrefix", "/category/"+pageIndex+"?pageIndex");
        return  "Home/Page/articleListByCategory";
    }
}
