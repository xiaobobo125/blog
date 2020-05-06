package com.bolife.blog.mapper;

import com.bolife.blog.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 16:50
 * @Description:   消息相关操作
 */
@Mapper
public interface NoticeMapper {

    /**
    * @Description: 获取所有已发布状态的消息
    * @Param: status消息发布的状态
    * @return: 已发布的消息
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    
    public List<Notice> listNotice(@Param("status") Integer status);

    Notice getNoticeById(@Param("noticeId") Integer noticeId);
}
