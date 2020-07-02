package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.entity.*;
import com.bolife.blogspringboot.service.*;
import com.bolife.blogspringboot.util.FinalDefine;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 14:34
 * @Description:
 */
@Controller
public class HomeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagServicel;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LinkService linkService;
    
    

    @RequestMapping({"/","/article"})
    public String goHome(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                         @RequestParam(value = "pageSize",defaultValue = FinalDefine.PAGESIZE)Integer pageSize,
                        Model model){
        List<Notice> allNotice = noticeService.getAllNotice();
        PageInfo<Article> allArticle = articleService.getAllArticle(pageIndex, pageSize);
        List<Tag> allTag = tagServicel.getAllTag();
        List<Comment> nearComment = commentService.getNearComment(10);
        List<Link> allLink = linkService.getAllLink();
        model.addAttribute("allTagList",allTag);
        model.addAttribute("pageInfo",allArticle);
        model.addAttribute("noticeList",allNotice);
        model.addAttribute("recentCommentList",nearComment);
        model.addAttribute("linkList",allLink);
        model.addAttribute("pageUrlPrefix", "/article?pageIndex");
        return "Home/index";
    }
}
