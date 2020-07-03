package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:50
 * @Description:
 */
@Mapper
public interface CommentMapper {
    Integer findCountComment();

    List<Comment> findNearComment(@Param("number") Integer number);

    List<Comment> findCommentByArticleId(@Param("aid") Integer aid);
}
