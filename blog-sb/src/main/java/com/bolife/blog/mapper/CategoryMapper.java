package com.bolife.blog.mapper;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 11:35
 * @Description: 分类列表的持久层方法
 */
@Mapper
public interface CategoryMapper {
    /**
    * @Description: 获取所有的分类列表
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public List<Category> listCategory();

    /***
     * 获取分类的个数
     * @return
     */
    public Integer countCategory();

    /***
     * 根据ID获取分类
     * @param cid
     */
    Category getCategoryById(@Param("cid") Integer cid);

    void insert(Category category);

    void deleteCategory(Integer id);

    void updateCategory(Category category);
}
