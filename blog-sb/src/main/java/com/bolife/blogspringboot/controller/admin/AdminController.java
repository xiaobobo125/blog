package com.bolife.blogspringboot.controller.admin;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Comment;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 16:40
 * @Description:
 */
@Controller
public class AdminController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/admin")
    public String goAdmin(Model model){
        List<Article> article = articleService.getArticleUpdate(5);
        model.addAttribute("articleList",article);
        List<Comment> nearComment = commentService.getNearComment(5);
        model.addAttribute("commentList",nearComment);
        return "Admin/index";
    }
}
