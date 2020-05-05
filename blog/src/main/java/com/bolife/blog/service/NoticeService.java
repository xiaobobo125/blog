package com.bolife.blog.service;

import com.bolife.blog.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 16:48
 * @Description: 处理消息事务
 */
public interface NoticeService {
    /**
    * @Description: 获取所有已发布消息
    * @Param: status：消息的状态
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Notice> listNotice(@Param(value = "status") Integer status);
}
