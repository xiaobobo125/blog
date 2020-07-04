package com.bolife.blogspringboot.controller.admin;

import com.bolife.blog.entity.Page;
import com.bolife.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:34
 * @Description:
 */
@Controller
@RequestMapping("/admin/page")
public class AdminPageController {
    @Autowired(required = false)
    private PageService pageService;


    @RequestMapping("")
    public String allPage(Model model){
        List<Page> pages = pageService.listPage(null);
        model.addAttribute("pageList",pages);
        model.addAttribute("listStatus",2);
        return "Admin/Page/index";
    }

    @RequestMapping("/insert")
    public ModelAndView insertPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/Page/insert");
        model.addAttribute("listStatus",2);
        return modelAndView;
    }
}
