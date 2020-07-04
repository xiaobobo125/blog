package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:25
 * @Description:
 */
@Mapper
public interface ArticleMapper {
    public List<Article> findAllArticle(Map<String,Object> condition);

    Integer findArticleCount();

    List<Article> findArticleByCommentCount(@Param("count") Integer count);

    List<Article> findRandomArticle(@Param("limit") int limit);

    Article findArticleById(@Param("aid") Integer aid);

    List<Article> findArticleByCategories(@Param("categoryIds") List<Category> categoryIds,
                                          @Param("limit") Integer limit);

    List<Article> findArticleByViewCount(@Param("limit") int limit);

    Article findAfterArticle(@Param("aid") Integer aid);
    Article findBeforeArticle(@Param("aid") Integer aid);

    void updateArticle(Article article);

    Integer getArticleViewCount();

    List<Article> findArticleUpdate(@Param("limit") Integer limit);
}
