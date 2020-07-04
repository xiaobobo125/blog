package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:22
 * @Description:
 */
public interface ArticleService {
    public PageInfo<Article> getAllArticle(Integer pageNum,Integer pageSize, Map<String,Object> condition);

    Integer getCountArticle();

    Integer getViewCount();

    Article getArticleLastUpdate();

    List<Article> getArticleByComment(Integer count);

    List<Article> getArticleByRandom(int count);

    Article getArticleById(Integer aid);

    List<Article> getArticlesByCategories(List<Category> categoiesByArticleId,Integer articleNum);

    List<Article> getArticleByViewCount(int limit);

    Article getAfterArticle(Integer aid);

    Article getBeforeArticle(Integer aid);

    void updateArticle(Article articleById);

    List<Article> getArticle();
    List<Article> getArticleUpdate(Integer limie);
}
