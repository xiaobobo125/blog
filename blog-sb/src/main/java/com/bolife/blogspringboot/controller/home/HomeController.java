package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Notice;
import com.bolife.blogspringboot.entity.Options;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.NoticeService;
import com.bolife.blogspringboot.service.OptionService;
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
    private OptionService optionService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String goHome(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = FinalDefine.PAGESIZE)Integer pageSize,
                        Model model){
        Options options = optionService.getOptions();
        List<Notice> allNotice = noticeService.getAllNotice();
        PageInfo<Article> allArticle = articleService.getAllArticle(pageNum, pageSize);
        model.addAttribute("pageInfo",allArticle);
        model.addAttribute("noticeList",allNotice);
        model.addAttribute("options",options);
        return "Home/index";
    }
}
