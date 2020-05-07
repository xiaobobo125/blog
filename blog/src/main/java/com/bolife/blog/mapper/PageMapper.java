package com.bolife.blog.mapper;

import com.bolife.blog.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 18:00
 * @Description:
 */
@Mapper
public interface PageMapper {

    public List<Page> listPage(@Param("status") Integer status);
}
