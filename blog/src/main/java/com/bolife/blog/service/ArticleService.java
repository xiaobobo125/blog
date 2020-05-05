package com.bolife.blog.service;

import com.bolife.blog.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:18
 * @Description: 文章事务管理
 */
public interface ArticleService {
    
    /**
    * @Description: 分页查询方法
    * @param pageIndex 第几页开始
    * @param pageSize  一页显示多少
    * @param criteria  查询条件
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, Map<String,Object> criteria);



}
