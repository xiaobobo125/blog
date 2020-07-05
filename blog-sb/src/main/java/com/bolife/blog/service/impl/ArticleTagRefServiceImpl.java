package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Tag;
import com.bolife.blog.mapper.ArticleTagRefMapper;
import com.bolife.blog.service.ArticleCategoryRefService;
import com.bolife.blog.service.ArticleTagRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 15:51
 * @Description:
 */
@Service
public class ArticleTagRefServiceImpl implements ArticleTagRefService {
    @Autowired(required = false)
    private ArticleTagRefMapper articleTagRefMapper;
    @Override
    public List<Tag> listTagByArticleId(Integer articleId) {
        return articleTagRefMapper.listTagByArticleId(articleId);
    }
}
