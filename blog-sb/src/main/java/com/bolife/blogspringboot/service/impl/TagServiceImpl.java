package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.entity.Tag;
import com.bolife.blogspringboot.mapper.TagMapper;
import com.bolife.blogspringboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:55
 * @Description:
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Integer getCountTag() {
        return tagMapper.findCountTag();
    }

    @Override
    public List<Tag> getAllTag() {
        return tagMapper.findAllTag();
    }

    @Override
    public List<Tag> getTagsByArticleId(Integer aid) {
        return tagMapper.getTagsByArticleId(aid);
    }

    @Override
    public Tag getTagById(Integer tid) {
        return tagMapper.findTagById(tid);
    }
}
