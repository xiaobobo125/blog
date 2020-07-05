package com.bolife.blog.mapper;

import com.bolife.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 18:01
 * @Description: 标签的持久层方法
 */
@Mapper
public interface TagMapper {
    /**
    * @Description: 获取所有标签
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Tag> listTag();

    /***
     * 获取标签的个数
     * @return
     */
    public Integer countTag();

    /***
     * 根据ID获取tag
     * @param tagId
     * @return
     */
    Tag getTagById(@Param("tagId") Integer tagId);

    void insert(Tag tag);

    void update(Tag tag);

    void deleteById(Integer id);
}
