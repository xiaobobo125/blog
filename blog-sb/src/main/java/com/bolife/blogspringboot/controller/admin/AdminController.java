package com.bolife.blogspringboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 16:40
 * @Description:
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String goAdmin(){
        return "Admin/index";
    }
}
