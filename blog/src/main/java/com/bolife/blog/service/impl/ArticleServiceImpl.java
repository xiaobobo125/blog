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

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    private ArticleMapper articleMapper;
    @Autowired(required = false)
    private ArticleCategoryRefMappler articleCategoryRefMappler;

    @Override
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, Map<String, Object> criteria) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Article> articleList = articleMapper.findAll();
        for (int i = 0; i < articleList.size(); i++) {
            List<Category> categories = articleCategoryRefMappler.listCategoryByArticleId(articleList.get(i).getArticleId());
            if (categories == null|| categories.size()==0){
                categories = new ArrayList<>();
                categories.add(Category.Default());
            }
            articleList.get(i).setCategoryList(categories);
        }
        return new PageInfo<Article>(articleList);
    }
}
