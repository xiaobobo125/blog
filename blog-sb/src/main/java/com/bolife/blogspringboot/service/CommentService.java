package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.Comment;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:49
 * @Description:
 */
public interface CommentService {
    public Integer getCountComment();

    List<Comment> getNearComment(Integer i);
}
