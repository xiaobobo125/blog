package com.bolife.blog.mapper;

import com.bolife.blog.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 17:28
 * @Description: 友情链接
 */
@Mapper
public interface LinkMapper {
    /**
    * @Description: 获取所有已发布的友情链接
    * @Param: status：发布状态
    * @return: 所有的链接
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Link> listLink(@Param(value = "status")Integer status);
}
