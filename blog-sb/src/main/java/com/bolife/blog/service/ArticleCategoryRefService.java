package com.bolife.blog.service;

import com.bolife.blog.entity.Category;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 15:46
 * @Description:
 */
public interface ArticleCategoryRefService {
    public List<Category> listCategoryByArticleId( Integer value);
}
