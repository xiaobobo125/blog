package com.bolife.blog.service;

import com.bolife.blog.entity.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 19:02
 * @Description: 评论的业务层管理
 */
public interface CommentService {
    /**
    * @Description: 获取最新的评论
    * @Param: limit：评论的限制条数
    * @return:  最新评论的列表
    * @Author: Mr.BoBo
    * @Date: 2020/5/4
    */
    public List<Comment> listRecentComment(Integer limit);

    /***
     * 根据文章ID获取评论列表
     * @param aid
     * @return
     */
    List<Comment> listCommentByArticleId(Integer aid);

    void insertComment(Comment comment);

    Comment getCommentById(Integer cid);

    void deleteComment(Integer cid);

    List<Comment> listChildComment(Integer cid);

    void updateComment(Comment comment);

    PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize);
}
