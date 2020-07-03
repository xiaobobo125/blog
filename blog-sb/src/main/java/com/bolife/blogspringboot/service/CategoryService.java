package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.Category;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:25
 * @Description:
 */
public interface CategoryService {
    List<Category> getAllCategory();

    Integer getCountCategory();

    Category getCategoryById(Integer cid);

    List<Category> getCategoiesByArticleId(Integer aid);
}
