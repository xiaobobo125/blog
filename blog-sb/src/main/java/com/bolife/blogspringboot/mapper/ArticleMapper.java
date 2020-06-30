package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 16:25
 * @Description:
 */
@Mapper
public interface ArticleMapper {
    public List<Article> findAllArticle();
}
