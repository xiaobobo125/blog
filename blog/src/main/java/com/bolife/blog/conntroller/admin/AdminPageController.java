package com.bolife.blog.conntroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:34
 * @Description:
 */
@Controller
@RequestMapping("/admin/page")
public class AdminPageController {

    @RequestMapping("/insert")
    public ModelAndView insertPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/Page/insert");
        return modelAndView;
    }
}
