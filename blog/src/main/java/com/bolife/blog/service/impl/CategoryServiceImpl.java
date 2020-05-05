package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Category;
import com.bolife.blog.mapper.CategoryMapper;
import com.bolife.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 11:34
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    @Override
    public Integer countCategory() {
        return categoryMapper.countCategory();
    }

    @Override
    public Category getCategoryById(Integer cid) {
        Category categoryById = categoryMapper.getCategoryById(cid);
        return categoryById;
    }


}
