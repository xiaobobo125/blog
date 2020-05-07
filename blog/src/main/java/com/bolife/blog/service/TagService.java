package com.bolife.blog.service;

import com.bolife.blog.entity.Tag;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 17:59
 * @Description: 标签的事务管理
 */
public interface TagService {
    
    /**
    * @Description: 所有标签的显示
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Tag> listTag();
    
    /**
    * @Description: 获取标签的个数
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countTag();

    Tag getTagById(Integer tagId);

    List<Tag> listTagWithCount();

    void insert(Tag tag);

    void updateTag(Tag tag);

    void deleteTag(Integer id);
}
