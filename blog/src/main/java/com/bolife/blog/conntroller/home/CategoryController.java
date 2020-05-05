package com.bolife.blog.conntroller.home;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Category;
import com.bolife.blog.entity.Tag;
import com.bolife.blog.enums.EnArticleStatus;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.CategoryService;
import com.bolife.blog.service.TagService;
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
 * @Date: 2020/5/5 16:31
 * @Description: 分类Controller
 */
@Controller
public class CategoryController {
    @Autowired(required = false)
    private CategoryService categoryService;

    @Autowired(required = false)
    private ArticleService articleService;

    @Autowired(required = false)
    private TagService tagService;

    @RequestMapping("/category/{cid}")
    public String getArticleListByCategory(@PathVariable("cid") Integer cateId,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                           Model model){
        //该分类信息
        Category category = categoryService.getCategoryById(cateId);
        if (category == null) {
            return "redirect:/404";
        }
        model.addAttribute("category", category);

        //文章列表
        Map<String,Object> criteria = new HashMap<>();
        criteria.put("categoryId",cateId);
        criteria.put("status", EnArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo",articlePageInfo);

        //侧边栏
        //标签列表显示
        List<Tag> tags = tagService.listTag();
        model.addAttribute("tagList",tags);

        //获得随机文章
        List<Article> articleList = articleService.listRandomArticle(8);
        model.addAttribute("articleList",articleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        model.addAttribute("pageUrlPrefix", "/category/"+pageIndex+"?pageIndex");
        return "Home/Page/articleListByCategory";
    }
}
