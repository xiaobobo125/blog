package com.bolife.blog.test;

import com.bolife.blog.entity.Article;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.impl.ArticleServiceImpl;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 11:51
 * @Description:
 */
public class ArticleTest {
    public static void main(String[] args) {
        Article article = new Article();
        article.setArticleId(24);
        article.setArticleTitle("测试ArticleUpdate");
        ArticleService articleService = new ArticleServiceImpl();
        articleService.updateArticle(article);
    }
}
