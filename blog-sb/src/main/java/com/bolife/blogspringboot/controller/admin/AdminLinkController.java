package com.bolife.blogspringboot.controller.admin;

import com.bolife.blog.entity.Link;
import com.bolife.blog.enums.EnLinkStatus;
import com.bolife.blog.service.LinkService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.RegEx;
import java.util.Date;
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

    @RequestMapping("")
    public String allLink(Model model){
        List<Link> links = linkService.listLink(null);
        model.addAttribute("linkList",links);
        model.addAttribute("listStatus",3);
        return "Admin/Link/index";
    }

    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertSubmit(Link link){
        link.setLinkCreateTime(new Date());
        link.setLinkUpdateTime(new Date());
        link.setLinkStatus(1);
        linkService.insertLink(link);
        return "redirect:/admin/link/insert";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editLink(@PathVariable("id") Integer id,Model model){
        Link link = linkService.getLinkById(id);
        model.addAttribute("linkCustom",link);
        List<Link> links = linkService.listLink(null);
        model.addAttribute("linkList",links);
        model.addAttribute("listStatus",3);
        return "Admin/Link/edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteLink(@PathVariable("id") Integer id)  {
        linkService.deleteLink(id);
        return "redirect:/admin/link";
    }

    @RequestMapping(value = "/insert")
    public String insertLinkView(Model model)  {
        List<Link> linkList = linkService.listLink(null);
        model.addAttribute("linkList",linkList);
        model.addAttribute("listStatus",3);
        return "Admin/Link/insert";
    }

    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    public String editLinkSubmit(Link link)  {
        link.setLinkUpdateTime(new Date());
        linkService.updateLink(link);
        return "redirect:/admin/link";
    }
}
