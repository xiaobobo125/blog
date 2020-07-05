package com.bolife.blog.mapper;

import com.bolife.blog.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

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

    /***
     * 获取友情链接的个数
     * @param status
     * @return
     */
    public Integer countLink(@Param("status") Integer status);

    void insertLink(Link link);

    Link getLinkById(@Param("id") Integer id);

    void deleteLink(@Param("id") Integer id);

    void updateLink(Link link);
}
