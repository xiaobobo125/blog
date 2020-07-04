package com.bolife.blogspringboot.controller.home;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Link;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/4 16:07
 * @Description:
 */
@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/goLink")
    public String goLink(Model model){
        List<Article> mostCommentArticleList = articleService.getArticleByComment(5);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/applyLink";
    }

    @RequestMapping(value = "/applyLinkSubmit",method = RequestMethod.POST)
    @ResponseBody
    public void applyLinkSubmit(Link link)  {
        link.setLinkStatus(0);
        link.setLinkCreateTime(new Date());
        link.setLinkUpdateTime(new Date());
        linkService.insertLink(link);
    }
}
