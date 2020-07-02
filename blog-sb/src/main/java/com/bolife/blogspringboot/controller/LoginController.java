package com.bolife.blogspringboot.controller;

import com.bolife.blogspringboot.entity.User;
import com.bolife.blogspringboot.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.bolife.blogspringboot.util.MyUtils.getIpAddr;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 15:38
 * @Description:
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String goLogin(){
        return "Admin/login";
    }

    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> data = new HashMap<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByUserName(username);
        if(user==null) {
            data.put("code",0);
            data.put("msg","用户名无效！");
        } else if(!user.getUserPass().equals(password)) {
            data.put("code",0);
            data.put("msg","密码错误！");
        } else {
            data.put("code",1);
            data.put("msg","");
            request.getSession().setAttribute("user",user);
            if(rememberme != null){
                Cookie userCookie = new Cookie("username", username);
                userCookie.setMaxAge(60*60*24*3);
                Cookie pwdCookie = new Cookie("password", password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(userCookie);
                response.addCookie(pwdCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            userService.updateUser(user);
        }
        return new JSONObject(data).toString();
    }
}
