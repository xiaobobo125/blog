package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.entity.Tag;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:54
 * @Description:
 */
public interface TagService {
    public Integer getCountTag();
    public List<Tag> getAllTag();

    List<Tag> getTagsByArticleId(Integer aid);

    Tag getTagById(Integer tid);
}
