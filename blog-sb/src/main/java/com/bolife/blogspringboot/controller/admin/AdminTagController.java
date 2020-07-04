package com.bolife.blogspringboot.controller.admin;

import com.bolife.blog.entity.ArticleTagRef;
import com.bolife.blog.entity.Tag;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 13:27
 * @Description:
 */
@Controller
@RequestMapping("/admin/tag")
public class AdminTagController {
    @Autowired(required = false)
    private TagService tagService;

    @Autowired(required = false)
    private ArticleService articleService;


    @RequestMapping(value = "")
    public ModelAndView index()  {
        ModelAndView modelandview = new ModelAndView();
        List<Tag> tagList = tagService.listTagWithCount();
        modelandview.addObject("tagList",tagList);
        modelandview.addObject("listStatus",1);
        modelandview.setViewName("Admin/Tag/index");
        return modelandview;
    }

    @RequestMapping("/insertSubmit")
    public String insertTag(Tag tag){
        tagService.insert(tag);
        return "redirect:/admin/tag";
    }

    @RequestMapping("/edit/{id}")
    public String editTag(@PathVariable("id") Integer id,Model model){
        Tag tagById = tagService.getTagById(id);
        model.addAttribute("tag",tagById);
        List<Tag> tagList = tagService.listTagWithCount();
        model.addAttribute("tagList",tagList);
        model.addAttribute("listStatus",1);
        return "Admin/Tag/edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteTag(@PathVariable("id") Integer id)  {
        Integer count = articleService.countArticleByTagId(id);
        if (count == 0) {
            tagService.deleteTag(id);
        }
        return "redirect:/admin/tag";
    }

    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    public String editTagSubmit(Tag tag)  {
        tagService.updateTag(tag);
        return "redirect:/admin/tag";
    }
}
