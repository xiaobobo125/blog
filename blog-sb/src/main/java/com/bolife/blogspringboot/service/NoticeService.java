package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.Notice;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:07
 * @Description:
 */
public interface NoticeService {
    public List<Notice> getAllNotice();

    Notice getNoticeById(Integer nid);
}
