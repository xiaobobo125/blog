package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Comment;
import com.bolife.blogspringboot.mapper.CommentMapper;
import com.bolife.blogspringboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:49
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public Integer getCountComment() {
        return commentMapper.findCountComment();
    }

    @Override
    public List<Comment> getNearComment(Integer i) {
        return commentMapper.findNearComment(i);
    }

    @Override
    public List<Comment> getCommentByArticleId(Integer aid) {
        return commentMapper.findCommentByArticleId(aid);
    }

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }
}
