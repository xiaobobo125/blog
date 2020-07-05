package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Category;
import com.bolife.blog.mapper.ArticleCategoryRefMappler;
import com.bolife.blog.service.ArticleCategoryRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 15:47
 * @Description:
 */
@Service
public class ArticleCategoryRefServiceImpl implements ArticleCategoryRefService {
    @Autowired(required = false)
    private ArticleCategoryRefMappler articleCategoryRefMappler;

    @Override
    public List<Category> listCategoryByArticleId(Integer value) {
        return articleCategoryRefMappler.listCategoryByArticleId(value);
    }
}
