package com.bolife.blog.service;

import com.bolife.blog.entity.Tag;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/6 15:51
 * @Description:
 */
public interface ArticleTagRefService {
    List<Tag> listTagByArticleId(Integer articleId);
}
