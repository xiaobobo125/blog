package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.ArticleCategoryRef;
import com.bolife.blog.entity.ArticleTagRef;
import com.bolife.blog.entity.Category;
import com.bolife.blog.enums.ArticleCommentStatus;
import com.bolife.blog.mapper.ArticleCategoryRefMappler;
import com.bolife.blog.mapper.ArticleMapper;
import com.bolife.blog.mapper.ArticleTagRefMapper;
import com.bolife.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:25
 * @Description:
 */

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    private ArticleMapper articleMapper;
    @Autowired(required = false)
    private ArticleCategoryRefMappler articleCategoryRefMappler;

    @Autowired(required = false)
    private ArticleTagRefMapper articleTagRefMapper;

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
            return articleMapper.listRandomArticle(i);
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

    @Override
    public int countArticleByCategoryId(Integer id) {
        Integer count = 0;
        try {
            count = articleCategoryRefMappler.countArticleByCategoryId(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据分类统计文章数量失败, categoryId:{}, cause:{}", id, e);
        }
        return count;
    }

    @Override
    public Integer countArticleByTagId(Integer id) {
        return articleTagRefMapper.countArticleByTagId(id);
    }

    @Override
    public List<Article> listRecentArticle(int limit) {
        return articleMapper.listArticleByLimit(limit);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertArticle(Article article) {
        //添加文章
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleIsComment(ArticleCommentStatus.ALLOW.getValue());
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);
        article.setArticleOrder(1);
        articleMapper.insert(article);
        //添加分类和文章关联
        for (int i = 0; i < article.getCategoryList().size(); i++) {
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef(article.getArticleId(), article.getCategoryList().get(i).getCategoryId());
            articleCategoryRefMappler.insert(articleCategoryRef);
        }
        //添加标签和文章关联
        for (int i = 0; i < article.getTagList().size(); i++) {
            ArticleTagRef articleTagRef = new ArticleTagRef(article.getArticleId(), article.getTagList().get(i).getTagId());
            articleTagRefMapper.insert(articleTagRef);
        }
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArticleDetail(Article article) {
        article.setArticleUpdateTime(new Date());
        articleMapper.update(article);

        if (article.getTagList() != null) {
            //删除标签和文章关联
            articleTagRefMapper.deleteByArticleId(article.getArticleId());
            //添加标签和文章关联
            for (int i = 0; i < article.getTagList().size(); i++) {
                ArticleTagRef articleTagRef = new ArticleTagRef(article.getArticleId(), article.getTagList().get(i).getTagId());
                articleTagRefMapper.insert(articleTagRef);
            }
        }

        if (article.getCategoryList() != null) {
            //添加分类和文章关联
            articleCategoryRefMappler.deleteByArticleId(article.getArticleId());
            //删除分类和文章关联
            for (int i = 0; i < article.getCategoryList().size(); i++) {
                ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef(article.getArticleId(), article.getCategoryList().get(i).getCategoryId());
                articleCategoryRefMappler.insert(articleCategoryRef);
            }
        }
    }
}
