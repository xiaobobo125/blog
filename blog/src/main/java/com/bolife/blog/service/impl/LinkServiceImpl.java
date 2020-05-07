package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Link;
import com.bolife.blog.mapper.LinkMapper;
import com.bolife.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/4 17:27
 * @Description:
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired(required = false)
    private LinkMapper linkMapper;
    @Override
    public List<Link> listLink(Integer status) {
        return linkMapper.listLink(status);
    }

    @Override
    public Integer countLink(Integer status) {
        return linkMapper.countLink(status);
    }

    @Override
    public void insertLink(Link link) {
        linkMapper.insertLink(link);
    }

    @Override
    public Link getLinkById(Integer id)  {
        return linkMapper.getLinkById(id);
    }

    @Override
    public void deleteLink(Integer id) {
        linkMapper.deleteLink(id);
    }

    @Override
    public void updateLink(Link link) {
        linkMapper.updateLink(link);
    }

}
