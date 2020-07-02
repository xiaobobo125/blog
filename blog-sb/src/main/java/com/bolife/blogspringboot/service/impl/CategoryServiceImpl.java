package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.mapper.CategoryMapper;
import com.bolife.blogspringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:25
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.findAllCategory();
    }

    @Override
    public Integer getCountCategory() {
        return categoryMapper.findCountCategory();
    }
}
