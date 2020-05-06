package com.bolife.blog.mapper;

import com.bolife.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 19:05
 * @Description:
 */
@Mapper
public interface CommentMapper {
    public List<Comment> listRecentComment(Integer limit);

    List<Comment> listCommentByArticleId(Integer aid);

    void insert(Comment comment);
}
