package com.bolife.blog.mapper;

import com.bolife.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:28
 * @Description: 文章dao
 */
@Mapper
public interface ArticleMapper {
    
    public List<Article> pageArticle(@Param("pageIndex") Integer pageIndex,
                                     @Param("pageSize") Integer pageSize,
                                     @Param("status") Integer status);
    /**
    * @Description: 查询全部的文章信息
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Article> findAll();
    
    /**
    * @Description: 根据ID获取文章
    * @Param: status：状态值
    * @Param: articleId：文章ID
    * @return:
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public Article getArticleByStatusAndId(Integer status, Integer articleId);
}
