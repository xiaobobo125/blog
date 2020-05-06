package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Category;
import com.bolife.blog.mapper.ArticleCategoryRefMappler;
import com.bolife.blog.mapper.ArticleMapper;
import com.bolife.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:25
 * @Description:
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    private ArticleMapper articleMapper;
    @Autowired(required = false)
    private ArticleCategoryRefMappler articleCategoryRefMappler;

    @Override
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, Map<String, Object> criteria) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Article> articleList = articleMapper.findAll(criteria);
        for (int i = 0; i < articleList.size(); i++) {
            List<Category> categories = articleCategoryRefMappler.listCategoryByArticleId(articleList.get(i).getArticleId());
            if (categories == null || categories.size() == 0) {
                categories = new ArrayList<>();
                categories.add(Category.Default());
            }
            articleList.get(i).setCategoryList(categories);
        }
        return new PageInfo<Article>(articleList);
    }

    @Override
    public Integer countArticle(Integer status) {
        return articleMapper.countArticle(status);
    }

    @Override
    public Integer countArticleComment() {
        return articleMapper.countArticleComment();
    }

    @Override
    public Integer countArticleView() {
        return articleMapper.countArticleView();
    }

    @Override
    public Article getLastUpdateArticle() {
        return articleMapper.getLastUpdateArticle();
    }

    @Override
    public List<Article> listRandomArticle(Integer limit) {
        return articleMapper.listRandomArticle(limit);
    }

    @Override
    public List<Article> listArticleByCommentCount(Integer num) {
        return articleMapper.listArticleByCommentCount(num);
    }

    @Override
    public Article getArticleByStatusAndId(Integer status, Integer aid) {
        return articleMapper.getArticleByStatusAndId(status,aid);
    }

    @Override
    public List<Integer> listCategoryIdByArticleId(Integer aid) {
        return articleCategoryRefMappler.listCategoryIdByArticleId(aid);
    }

    @Override
    public List<Article> listArticleByCategoryIds(List<Integer> categoryIds, int i) {
        if (categoryIds == null || categoryIds.size() == 0) {
            return null;
        }
        return articleMapper.findArticleByCategoryIds(categoryIds, i);
    }

    @Override
    public List<Article> listArticleByViewCount(int limit) {
        return articleMapper.listArticleByViewCount(limit);
    }

    @Override
    public Article getAfterArticle(Integer aid) {
        return articleMapper.getAfterArticle(aid);
    }

    @Override
    public Article getPreArticle(Integer aid) {
        return articleMapper.getPreArticle(aid);
    }

    @Override
    public List<Article> listAllNotWithContent() {
        return articleMapper.listAllNotWithContent();
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Override
    public void updateCommentCount(Integer articleId) {
        articleMapper.updateCommentCount(articleId);
    }
}
