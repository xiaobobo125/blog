package com.bolife.blog.conntroller.home;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Tag;
import com.bolife.blog.enums.EnArticleStatus;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 14:42
 * @Description:
 */
@Controller
public class TagController {
    @Autowired(required = false)
    private TagService tagService;

    @Autowired(required = false)
    private ArticleService articleService;

    @RequestMapping(value = "/tag/{tagId}")
    public String getArticleByTagId(@PathVariable("tagId") Integer tagId,
                                    @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                    Model model){
        Tag tag = tagService.getTagById(tagId);
        if (tag==null){
            return "redirect:/404";
        }
        model.addAttribute("tag",tag);
        Map<String,Object> criteria = new HashMap<>();
        criteria.put("status", EnArticleStatus.PUBLISH.getValue());
        criteria.put("tagId",tag.getTagId());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo",articlePageInfo);

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
        model.addAttribute("pageUrlPrefix", "/tag?pageIndex");
        return "Home/Page/articleListByTag";
    }
}
