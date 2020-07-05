package com.bolife.blog.conntroller.admin;

import com.bolife.blog.entity.Notice;
import com.bolife.blog.enums.EnNoticeStatus;
import com.bolife.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:40
 * @Description:
 */
@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {

    @Autowired(required = false)
    private NoticeService noticeService;
    @RequestMapping(value = "/insert")
    public String insertNoticeView(Model model) {
        model.addAttribute("listStatus",4);
        return "Admin/Notice/insert";
    }

    @RequestMapping("")
    public String allNotice(Model model){
        List<Notice> notices = noticeService.listNotice(null);
        model.addAttribute("noticeList",notices);
        model.addAttribute("listStatus",4);
        return "Admin/Notice/index";
    }

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertNoticeSubmit(Notice notice) {
        notice.setNoticeCreateTime(new Date());
        notice.setNoticeUpdateTime(new Date());
        notice.setNoticeStatus(EnNoticeStatus.NORMAL.getStatus());
        notice.setNoticeOrder(1);
        noticeService.insertNotice(notice);
        return "redirect:/admin/notice";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteNotice(@PathVariable("id") Integer id) {
        noticeService.deleteNotice(id);
        return "redirect:/admin/notice";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editNoticeView(@PathVariable("id") Integer id, Model model) {
        Notice notice = noticeService.getNoticeById(id);
        model.addAttribute("notice", notice);
        model.addAttribute("listStatus",4);
        return "Admin/Notice/edit";
    }

    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editNoticeSubmit(Notice notice) {
        notice.setNoticeUpdateTime(new Date());
        noticeService.updateNotice(notice);
        return "redirect:/admin/notice";
    }
}
