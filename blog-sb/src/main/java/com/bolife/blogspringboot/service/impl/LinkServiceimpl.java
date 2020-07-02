package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Link;
import com.bolife.blogspringboot.mapper.LinkMapper;
import com.bolife.blogspringboot.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 14:00
 * @Description:
 */
@Service
public class LinkServiceimpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    @Override
    public List<Link> getAllLink() {
        return linkMapper.findAllLink();
    }

    @Override
    public Integer getCountLink() {
        return linkMapper.findCountLink();
    }
}
