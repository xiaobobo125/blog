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

    @Override
    public void insertComment(Comment comment) {
        try {
            commentMapper.insert(comment);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("创建评论失败：comment:{}, cause:{}", comment, e);
        }
    }

    @Override
    public Comment getCommentById(Integer cid) {
        return commentMapper.getCommentById(cid);
    }

    @Override
    public void deleteComment(Integer cid) {
        try {
            commentMapper.deleteComment(cid);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除评论失败, id:{}, cause:{}", cid, e);
        }
    }

    @Override
    public List<Comment> listChildComment(Integer cid) {
        return commentMapper.listChildComment(cid);
    }

    @Override
    public void updateComment(Comment comment) {
            try {
                commentMapper.update(comment);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("更新评论，comment:{}, cause:{}", comment, e);
            }
        }
}
