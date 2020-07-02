package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.Link;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:59
 * @Description:
 */
public interface LinkService {
    public List<Link> getAllLink();
    public Integer getCountLink();
}
