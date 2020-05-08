package com.bolife.blog.mapper;

import com.bolife.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:28
 * @Description: 文章dao
 */
@Mapper
public interface ArticleMapper {
    /***
     * 获取文章信息
     * @param pageIndex 起始地址
     * @param pageSize 文章个数
     * @param status    文章状态
     * @return
     */
    public List<Article> pageArticle(@Param("pageIndex") Integer pageIndex,
                                     @Param("pageSize") Integer pageSize,
                                     @Param("status") Integer status);
    /**
    * @Description: 查询全部的文章信息
    * @Param: 查询条件
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Article> findAll(Map<String,Object> criteria);
    
    /**
    * @Description: 根据ID获取文章
    * @Param: status：状态值
    * @Param: articleId：文章ID
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public Article getArticleByStatusAndId(@Param("status") Integer status, @Param("id") Integer articleId);
    
    /**
    * @Description: 获取文章的个数
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countArticle(@Param("status") Integer status);
    
    /**
    * @Description: 获取文章的评论个数
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countArticleComment();

    /***
     * 获取文章的浏览个数
     * @return
     */
    public Integer countArticleView();

    /***
     * 获取最后更新的记录
     * @return
     */
    public Article getLastUpdateArticle();

    /***
     * 获取随机文章
     * @param limit
     * @return
     */
    List<Article> listRandomArticle(@Param("limit") Integer limit);

    /***
     * 根据评论数查找文章
     * @param num
     * @return
     */
    List<Article> listArticleByCommentCount(@Param("num") Integer num);

    /***
     * 根据分类列表查找文章
     * @param categoryIds
     * @param limit
     * @return
     */
    List<Article> findArticleByCategoryIds(@Param("categoryIds") List<Integer> categoryIds,
                                           @Param("limit") Integer limit);

    /***
     * 根据观看数查找文章
     * @param limit
     * @return
     */
    List<Article> listArticleByViewCount(@Param(value = "limit")int limit);

    /***
     * 获得上一篇文章
     * @param id
     * @return
     */
    Article getAfterArticle(@Param(value = "id") Integer id);

    /**
     * 获得下一篇文章
     * @param id 文章ID
     * @return 文章
     */
    Article getPreArticle(@Param(value = "id") Integer id);

    /***
     * 获得所有的文章
     * @return
     */
    List<Article> listAllNotWithContent();

    /***
     * 更新文章信息
     * @param article
     * @return
     */
    Integer updateArticle(Article article);

    void updateCommentCount(@Param(value = "articleId")Integer articleId);

    int countArticleByCategoryId(Integer id);

    List<Article> listArticleByLimit(int limit);

    Integer countArticleByUser(Integer userId);

    void insert(Article article);

    void deleteById(Integer id);

    void update(Article article);
}
