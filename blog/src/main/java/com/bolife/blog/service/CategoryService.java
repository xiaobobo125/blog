package com.bolife.blog.service;

import com.bolife.blog.entity.Category;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 11:32
 * @Description: 获取分类列表
 */
public interface CategoryService {
    /**
    * @Description: 获取全部的分类列表
    * @return: 分类；列表
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public List<Category> listCategory();

    /**
    * @Description: 获取分类的个数
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countCategory();

    /***
     * 根据分类获取ID
     * @param cid
     * @return
     */
    public Category getCategoryById(Integer cid);
}
