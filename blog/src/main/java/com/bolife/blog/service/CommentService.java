package com.bolife.blog.service;

import com.bolife.blog.entity.Comment;

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
}
