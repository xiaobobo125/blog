package com.bolife.blog.conntroller.home;

import com.bolife.blog.entity.Article;
import com.bolife.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 09:55
 * @Description:
 */
@Controller
public class PageController {
    @Autowired(required = false)
    private ArticleService articleService;

    /**
     * 留言板
     * @return
     */
    @RequestMapping(value = "/message")
    public String message(Model model) {
        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/message";
    }
}
