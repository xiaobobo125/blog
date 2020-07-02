package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.mapper.ArticleMapper;
import com.bolife.blogspringboot.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:23
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> getAllArticle(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> allArticle = articleMapper.findAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(allArticle);
        return pageInfo;
    }

    @Override
    public Integer getCountArticle() {
        return articleMapper.findArticleCount();
    }

    @Override
    public Integer getViewCount() {
        List<Article> allArticle = articleMapper.findAllArticle();
        Integer count = 0;
        for (Article article : allArticle) {
            count+=article.getArticleViewCount();
        }
        return count;
    }

    @Override
    public Article getArticleLastUpdate() {
        List<Article> allArticle = articleMapper.findAllArticle();
        return allArticle.get(0);
    }
}
