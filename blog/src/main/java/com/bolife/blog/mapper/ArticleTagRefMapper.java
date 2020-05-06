package com.bolife.blog.mapper;

import com.bolife.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 15:52
 * @Description:
 */
@Mapper
public interface ArticleTagRefMapper {
    List<Tag> listTagByArticleId(@Param("value") Integer articleId);
}
