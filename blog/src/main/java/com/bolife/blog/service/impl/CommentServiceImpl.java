package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Comment;
import com.bolife.blog.enums.EnArticleStatus;
import com.bolife.blog.mapper.ArticleMapper;
import com.bolife.blog.mapper.CommentMapper;
import com.bolife.blog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 19:04
 * @Description:
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Autowired(required = false)
    private ArticleMapper articleMapper;
    @Override
    public List<Comment> listRecentComment(Integer limit) {
        List<Comment> commentList = null;
        try {
            commentList = commentMapper.listRecentComment(limit);
            for (int i = 0; i < commentList.size(); i++) {
                Article article = articleMapper.getArticleByStatusAndId(EnArticleStatus.PUBLISH.getValue(), commentList.get(i).getCommentArticleId());
                commentList.get(i).setArticle(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得最新评论失败, limit:{}, cause:{}", limit, e);
        }
        return commentList;
    }

    @Override
    public List<Comment> listCommentByArticleId(Integer aid) {
        return commentMapper.listCommentByArticleId(aid);
    }
}
