package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.ArticleCategoryRef;
import com.bolife.blogspringboot.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/3 12:56
 * @Description:
 */
public interface ArticleCategoryRefMapper {
    List<ArticleCategoryRef> getArticleByCategoryId(@Param("cid") Integer cid);

}
