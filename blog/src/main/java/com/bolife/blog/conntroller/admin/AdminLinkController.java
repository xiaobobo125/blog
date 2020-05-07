package com.bolife.blog.conntroller.admin;

import com.bolife.blog.entity.Link;
import com.bolife.blog.service.LinkService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:41
 * @Description:
 */
@Controller
@RequestMapping("/admin/link")
public class AdminLinkController {
    @Autowired(required = false)
    private LinkService linkService;

    @RequestMapping(value = "/insert")
    public ModelAndView insertLinkView()  {
        ModelAndView modelAndView = new ModelAndView();
        List<Link> linkList = linkService.listLink(null);
        modelAndView.addObject("linkList",linkList);
        modelAndView.setViewName("Admin/Link/insert");
        return modelAndView;
    }
}
