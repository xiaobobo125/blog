package com.bolife.blog.conntroller.admin;


import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Comment;
import com.bolife.blog.entity.User;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.CommentService;
import com.bolife.blog.service.UserService;
import com.bolife.blog.utils.MyUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.RegEx;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bolife.blog.utils.MyUtils.getIpAddr;


/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 13:25
 * @Description: 管理员的Controller
 */
@Controller
public class AdminController {

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private ArticleService articleService;

    @Autowired(required = false)
    private CommentService commentService;
    @RequestMapping("/admin")
    public String admin(Model model){
        //文章列表
        List<Article> articleList = articleService.listRecentArticle(5);
        model.addAttribute("articleList",articleList);
        //评论列表
        List<Comment> commentList = commentService.listRecentComment(5);
        model.addAttribute("commentList",commentList);
        return "Admin/index";
    }


    @RequestMapping("/regist")
    public String registPage() {
        return "Admin/regist";
    }

    @RequestMapping(value = "/login")
    public String loginPage(HttpServletRequest request) {
        return "Admin/login";
    }

    /***
     * 用户登陆
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/registVerify",method = RequestMethod.POST)
    @ResponseBody
    public String verifyRegist(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = userService.getUserByNameOrEmail(email);
        if(user!=null) {
            map.put("code",0);
            map.put("msg","该邮箱已被注册！");
        }else {
            //注册成功
            map.put("code",1);
            map.put("msg","");
            user = new User();
            user.setUserEmail(email);
            user.setUserNickname(username);
            user.setUserPass(password);
            user.setUserName(email);
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            user.setUserStatus(2);
            user.setUserAvatar("/img/default.jpg");
            userService.insert(user);
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response)  {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByNameOrEmail(username);
        if(user==null) {
            map.put("code",0);
            map.put("msg","用户名无效！");
        } else if(!user.getUserPass().equals(password)) {
            map.put("code",0);
            map.put("msg","密码错误！");
        } else {
            //登录成功
            map.put("code",1);
            map.put("msg","");
            //添加session
            request.getSession().setAttribute("user", user);
            //添加cookie
            if(rememberme!=null) {
                //创建两个Cookie对象
                Cookie nameCookie = new Cookie("username", username);
                //设置Cookie的有效期为3天
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie = new Cookie("password", password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            userService.updateUser(user);
        }
        String result = new JSONObject(map).toString();
        return result;
    }
    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value = "/admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }
}
