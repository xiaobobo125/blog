package com.bolife.blogspringboot.controller.admin;

import com.bolife.blog.entity.User;
import com.bolife.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "")
    public String userList(Model model)  {
        List<User> userList = userService.listUser();
        model.addAttribute("userList",userList);
        model.addAttribute("listStatus",5);
        return "Admin/User/index";

    }

    @RequestMapping(value = "/insert")
    public ModelAndView insertUserView()  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/User/insert");
        modelAndView.addObject("listStatus",5);
        return modelAndView;
    }

    @RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
    @ResponseBody
    public String checkUserName(HttpServletRequest request)  {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = request.getParameter("username");
        User user = userService.getUserByName(username);
        int id = Integer.valueOf(request.getParameter("id"));
        //用户名已存在,但不是当前用户(编辑用户的时候，不提示)
        if(user!=null) {
            if(user.getUserId()!=id) {
                map.put("code", 1);
                map.put("msg", "用户名已存在！");
            }
        } else {
            map.put("code",0);
            map.put("msg","");
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    @RequestMapping(value = "/checkUserEmail",method = RequestMethod.POST)
    @ResponseBody
    public String checkUserEmail(HttpServletRequest request)  {
        Map<String, Object> map = new HashMap<String, Object>();
        String email = request.getParameter("email");
        User user = userService.getUserByEmail(email);
        int id = Integer.valueOf(request.getParameter("id"));
        //用户名已存在,但不是当前用户(编辑用户的时候，不提示)
        if(user!=null) {
            if(user.getUserId()!=id) {
                map.put("code", 1);
                map.put("msg", "电子邮箱已存在！");
            }
        } else {
            map.put("code",0);
            map.put("msg","");
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertUserSubmit(User user)  {
        User user2 = userService.getUserByName(user.getUserName());
        User user3 = userService.getUserByEmail(user.getUserEmail());
        if(user2==null&&user3==null) {
            user.setUserRegisterTime(new Date());
            user.setUserStatus(1);
            userService.insert(user);
        }
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id)  {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editUserView(@PathVariable("id") Integer id)  {
        ModelAndView modelAndView = new ModelAndView();

        User user =  userService.getUserById(id);
        modelAndView.addObject("user",user);
        modelAndView.addObject("listStatus",5);
        modelAndView.setViewName("Admin/User/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    public String editUserSubmit(User user)  {
        userService.updateUser(user);
        return "redirect:/admin/user";
    }


    @RequestMapping(value = "/profile")
    public ModelAndView userProfileView(HttpSession session)  {
        ModelAndView modelAndView = new ModelAndView();
        User sessionUser = (User) session.getAttribute("user");
        User user =  userService.getUserById(sessionUser.getUserId());
        modelAndView.addObject("user",user);
        modelAndView.addObject("listStatus",5);
        modelAndView.setViewName("Admin/User/profile");
        return modelAndView;
    }
}
