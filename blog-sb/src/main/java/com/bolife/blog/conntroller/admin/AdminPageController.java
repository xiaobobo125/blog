package com.bolife.blog.conntroller.admin;

import com.bolife.blog.entity.Page;
import com.bolife.blog.enums.PageStatus;
import com.bolife.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertPageSubmit(Page page) {

        //判断别名是否存在
        Page checkPage = pageService.getPageByKey(null, page.getPageKey());
        if (checkPage == null) {
            page.setPageCreateTime(new Date());
            page.setPageUpdateTime(new Date());
            page.setPageStatus(PageStatus.NORMAL.getValue());
            pageService.insertPage(page);
        }
        return "redirect:/admin/page";
    }

    /**
     * 删除页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public String deletePage(@PathVariable("id") Integer id) {
        //调用service批量删除
        pageService.deletePage(id);
        return "redirect:/admin/page";
    }


    /**
     * 编辑页面页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editPageView(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();

        Page page = pageService.getPageById(id);
        modelAndView.addObject("page", page);

        modelAndView.setViewName("Admin/Page/edit");
        return modelAndView;
    }


    /**
     * 编辑页面提交
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editPageSubmit(Page page) {
        Page checkPage = pageService.getPageByKey(null, page.getPageKey());
        //判断别名是否存在且不是这篇文章
        if (Objects.equals(checkPage.getPageId(), page.getPageId())) {
            page.setPageUpdateTime(new Date());
            pageService.updatePage(page);
        }
        return "redirect:/admin/page";
    }
}
