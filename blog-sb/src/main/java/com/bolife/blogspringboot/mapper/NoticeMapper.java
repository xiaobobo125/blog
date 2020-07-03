package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:09
 * @Description:
 */
@Mapper
public interface NoticeMapper {
    List<Notice> findAllNotice();

    Notice findNoticeById(@Param("nid") Integer nid);
}
