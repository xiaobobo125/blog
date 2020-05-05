package com.bolife.blog.conntroller.home;

import com.bolife.blog.entity.*;
import com.bolife.blog.enums.EnArticleStatus;
import com.bolife.blog.enums.EnLinkStatus;
import com.bolife.blog.enums.EnNoticeStatus;
import com.bolife.blog.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:03
 * @Description:
 */
@Controller
public class IndexController {
    @Autowired(required = false)
    private ArticleService articleService;

    @Autowired(required = false)
    private NoticeService noticeService;

    @Autowired(required = false)
    private LinkService linkService;

    @Autowired(required = false)
    private TagService tagService;

    @Autowired(required = false)
    private CommentService commentService;

    @Autowired(required = false)
    private MenuService menuService;

    @Autowired(required = false)
    private CategoryService categoryService;

    @Autowired(required = false)
    private OptionsService optionsService;

    @RequestMapping(value = {"/","/article"})
    public String index(@RequestParam(required = false ,defaultValue = "1")Integer pageIndex,
                        @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                        Model model){
        //获取已发布的文章列表
        Map<String,Object> criteria = new HashMap<>();
        criteria.put("status", EnArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articleList = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("articleInfo",articleList);
        //获取显示内容的公告
        List<Notice> notices = noticeService.listNotice(EnNoticeStatus.NORMAL.getStatus());
        model.addAttribute("notices",notices);
        //获取显示类型的友情链接
        List<Link> links = linkService.listLink(EnLinkStatus.NORMAL.getValue());
        model.addAttribute("links",links);
        //侧边栏显示
        //标签列表显示
        List<Tag> tags = tagService.listTag();
        model.addAttribute("tags",tags);
        //获取评论信息
        List<Comment> comments = commentService.listRecentComment(10);
        model.addAttribute("comments",comments);
        model.addAttribute("pageUrlPrefix", "/article?pageIndex");
        return "/Home/index";
    }

    @RequestMapping("/404")
    public String NotFound(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "Home/Error/404";
    }

    @RequestMapping("/500")
    public String ServerError(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "Home/Error/500";
    }
}
