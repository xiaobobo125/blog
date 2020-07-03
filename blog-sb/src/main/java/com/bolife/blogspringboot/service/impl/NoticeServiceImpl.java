package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Notice;
import com.bolife.blogspringboot.mapper.NoticeMapper;
import com.bolife.blogspringboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:09
 * @Description:
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> getAllNotice() {
        return noticeMapper.findAllNotice();
    }

    @Override
    public Notice getNoticeById(Integer nid) {
        return noticeMapper.findNoticeById(nid);
    }
}
