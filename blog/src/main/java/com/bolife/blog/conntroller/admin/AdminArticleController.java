package com.bolife.blog.conntroller.admin;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Category;
import com.bolife.blog.entity.Tag;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.CategoryService;
import com.bolife.blog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:30
 * @Description:
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {
    @Autowired(required = false)
    private CategoryService categoryService;

    @Autowired(required = false)
    private TagService tagService;

    @Autowired(required = false)
    private ArticleService articleService;

    @RequestMapping("/insert")
    public String insertArticle(Model model){
        List<Category> categories = categoryService.listCategory();
        List<Tag> tags = tagService.listTag();
        model.addAttribute("categoryList",categories);
        model.addAttribute("tagList",tags);
        return "/Admin/Article/insert";
    }

    @RequestMapping("")
    public String allArticle(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @RequestParam(required = false) String status,Model model){
        HashMap<String, Object> criteria = new HashMap<>(1);
        if (status == null) {
            model.addAttribute("pageUrlPrefix", "/admin/article?pageIndex");
        } else {
            criteria.put("status", status);
            model.addAttribute("pageUrlPrefix", "/admin/article?status=" + status + "&pageIndex");
        }
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);
        return "Admin/Article/index";
    }
}
