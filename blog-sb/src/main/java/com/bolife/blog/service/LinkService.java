package com.bolife.blog.service;

import com.bolife.blog.entity.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 17:25
 * @Description: 友情链接事务
 */
public interface LinkService {
    /**
    * @Description: 获取所有友情链接
    * @Param: Status：友情链接的状态
    * @return: 链接的列表
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Link> listLink(Integer Status);
    
    /**
    * @Description: 获取友情链接的个数
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countLink(Integer value);

    void insertLink(Link link);

    Link getLinkById(Integer id);

    void deleteLink(Integer id);

    void updateLink(Link link);
}
