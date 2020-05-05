package com.bolife.blog.service;

import com.bolife.blog.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 15:18
 * @Description: 文章事务管理
 */
public interface ArticleService {
    
    /**
    * @Description: 分页查询方法
    * @param pageIndex 第几页开始
    * @param pageSize  一页显示多少
    * @param criteria  查询条件
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, Map<String,Object> criteria);

    /**
    * @Description: 统计文章的数量
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countArticle(Integer status);
    
    /**
    * @Description: 统计当前文章评论的个数
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countArticleComment();
    
    /**
    * @Description: 统计文章的观看人数
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Integer countArticleView();
    /**
    * @Description: 获取文章的最后更新时间
    * @Param: 
    * @return: 
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public Article getLastUpdateArticle();

    /***
     * 获取随机文章
     * @param limit
     * @return
     */
    public List<Article> listRandomArticle(Integer limit);

    /***
     * 获取热评文章
     * @param num
     * @return
     */
    List<Article> listArticleByCommentCount(Integer num);

    /***
     * 根据文章状态和ID获取文章信息
     * @param status
     * @param aid
     * @return
     */
    Article getArticleByStatusAndId(Integer status, Integer aid);

    /***
     * 根据文章ID查询分类ID
     * @param aid
     * @return
     */
    List<Integer> listCategoryIdByArticleId(Integer aid);

    /***
     * 根据分类ID查询文章
     * @param categoryIds
     * @param i
     * @return
     */
    List<Article> listArticleByCategoryIds(List<Integer> categoryIds, int i);

    /***
     * 根据浏览量查询文章
     * @param limit
     * @return
     */
    List<Article> listArticleByViewCount(int limit);

    Article getAfterArticle(Integer aid);

    Article getPreArticle(Integer aid);
}


