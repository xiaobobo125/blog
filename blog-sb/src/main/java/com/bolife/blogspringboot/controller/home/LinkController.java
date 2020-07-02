package com.bolife.blogspringboot.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 16:43
 * @Description:
 */
@Controller
public class LinkController {


    @RequestMapping("/replyLink")
    public String replyLink(){
        return "Home/page/applyLink";
    }
}
