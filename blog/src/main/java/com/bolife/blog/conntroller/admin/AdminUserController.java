package com.bolife.blog.conntroller.admin;

import com.bolife.blog.entity.User;
import com.bolife.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:52
 * @Description:
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired(required = false)
    private UserService userService;


    @RequestMapping(value = "/profile")
    public ModelAndView userProfileView(HttpSession session)  {
        ModelAndView modelAndView = new ModelAndView();
        User sessionUser = (User) session.getAttribute("user");
        User user =  userService.getUserById(sessionUser.getUserId());
        modelAndView.addObject("user",user);
        modelAndView.setViewName("Admin/User/profile");
        return modelAndView;
    }
}
