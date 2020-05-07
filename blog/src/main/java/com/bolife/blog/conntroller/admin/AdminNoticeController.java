package com.bolife.blog.conntroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:40
 * @Description:
 */
@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {

    @RequestMapping(value = "/insert")
    public String insertNoticeView() {
        return "Admin/Notice/insert";
    }
}
