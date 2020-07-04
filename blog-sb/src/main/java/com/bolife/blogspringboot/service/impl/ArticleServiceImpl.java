package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.ArticleCategoryRef;
import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.entity.User;
import com.bolife.blogspringboot.mapper.ArticleCategoryRefMapper;
import com.bolife.blogspringboot.mapper.ArticleMapper;
import com.bolife.blogspringboot.mapper.UserMapper;
import com.bolife.blogspringboot.service.ArticleService;
import com.bolife.blogspringboot.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:23
 * @Description:
 */
@Service
@SuppressWarnings("all")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo<Article> getAllArticle(Integer pageNum, Integer pageSize, Map<String,Object> condition) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> allArticle = articleMapper.findAllArticle(condition);
        PageInfo<Article> pageInfo = new PageInfo<>(allArticle);
        return pageInfo;
    }

    @Override
    public Integer getCountArticle() {
        return articleMapper.findArticleCount();
    }

    @Override
    public Integer getViewCount() {
        return articleMapper.getArticleViewCount();
    }

    @Override
    public Article getArticleLastUpdate() {
        List<Article> allArticle = articleMapper.findAllArticle(null);
        return allArticle.get(0);
    }

    @Override
    public List<Article> getArticleByComment(Integer count) {
        return articleMapper.findArticleByCommentCount(count);
    }

    @Override
    public List<Article> getArticleByRandom(int count) {
        return articleMapper.findRandomArticle(count);
    }

    @Override
    public Article getArticleById(Integer aid) {
        Article articleById = articleMapper.findArticleById(aid);
        User userById = userMapper.getUserById(articleById.getArticleUserId());
        articleById.setUser(userById);
        return articleById;
    }

    @Override
    public List<Article> getArticlesByCategories(List<Category> categoiesByArticleId, Integer articleNum) {
        if(categoiesByArticleId == null || categoiesByArticleId.size() == 0){
            return articleMapper.findRandomArticle(articleNum);
        }
        return articleMapper.findArticleByCategories(categoiesByArticleId,articleNum);
    }

    @Override
    public List<Article> getArticleByViewCount(int limit) {
        return articleMapper.findArticleByViewCount(limit);
    }

    @Override
    public Article getAfterArticle(Integer aid) {
        return articleMapper.findAfterArticle(aid);
    }
    @Override
    public Article getBeforeArticle(Integer aid) {
        return articleMapper.findBeforeArticle(aid);
    }

    @Override
    public void updateArticle(Article articleById) {
        articleMapper.updateArticle(articleById);
    }

    @Override
    public List<Article> getArticle() {
        return articleMapper.findAllArticle(null);
    }

    @Override
    public List<Article> getArticleUpdate(Integer limie) {
        return articleMapper.findArticleUpdate(limie);
    }
}
