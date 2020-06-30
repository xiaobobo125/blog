package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:22
 * @Description:
 */
public interface ArticleService {
    public PageInfo<Article> getAllArticle(Integer pageNum,Integer pageSize);
}
