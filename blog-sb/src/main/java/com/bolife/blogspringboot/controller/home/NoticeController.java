package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Notice;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/3 14:07
 * @Description:
 */
@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/notice/{nid}")
    public String getNotice(@PathVariable("nid")Integer nid, Model model){
        Notice noticeById = noticeService.getNoticeById(nid);
        List<Article> articleByComment = articleService.getArticleByComment(5);
        model.addAttribute("mostCommentArticleList",articleByComment);
        model.addAttribute("notice",noticeById);
        return  "Home/Page/noticeDetail";
    }
}
