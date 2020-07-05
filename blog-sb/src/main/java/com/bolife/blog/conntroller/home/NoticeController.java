package com.bolife.blog.conntroller.home;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Notice;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 10:05
 * @Description:
 */
@Controller
public class NoticeController {

    @Autowired(required = false)
    private NoticeService noticeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/notice/{noticeId}")
    public String notice(@PathVariable("noticeId") Integer noticeId,Model model){
        //公告内容和信息显示
        Notice notice = noticeService.getNoticeById(noticeId);
        model.addAttribute("notice", notice);
        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/noticeDetail";
    }
}
