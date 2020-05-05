package com.bolife.blog.mapper;

import com.bolife.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 16:20
 * @Description:
 */
@Mapper
public interface ArticleCategoryRefMappler {
    /**
    * @Description: 根据文章ID查询分类属性
    * @Param: articleId 文章ID
    * @return: 分类列表
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Category> listCategoryByArticleId(@Param("value") Integer value);

    /***
     * 根据文章ID查询分类ID
     * @param value
     * @return
     */
    List<Integer> listCategoryIdByArticleId(@Param("value") Integer value);
}
