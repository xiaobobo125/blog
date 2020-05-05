package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Tag;
import com.bolife.blog.mapper.TagMapper;
import com.bolife.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 18:00
 * @Description:
 */
@Service
@Slf4j
public class TabServiceImpl implements TagService{
    @Autowired(required = false)
    private TagMapper tagMapper;
    @Override
    public List<Tag> listTag() {
        List<Tag> tagList = null;
        try {
            tagList = tagMapper.listTag();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得所有标签失败, cause:{}", e);
        }
        return tagList;
    }

    @Override
    public Integer countTag() {
        return tagMapper.countTag();
    }
}
