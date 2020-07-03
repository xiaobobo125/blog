package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:56
 * @Description:
 */
@Mapper
public interface TagMapper {
    Integer findCountTag();

    List<Tag> findAllTag();

    List<Tag> getTagsByArticleId(@Param("aid") Integer aid);

    Tag findTagById(@Param("tid") Integer tid);

}
