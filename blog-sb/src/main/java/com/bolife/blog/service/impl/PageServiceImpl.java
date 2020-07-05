package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Page;
import com.bolife.blog.mapper.PageMapper;
import com.bolife.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 17:59
 * @Description:
 */
@Service
public class PageServiceImpl implements PageService {
    @Autowired(required = false)
    private PageMapper pageMapper;
    @Override
    public List<Page> listPage(Integer status) {
        return pageMapper.listPage(status);
    }

    @Override
    public Page getPageByKey(Integer status, String key) {
        return pageMapper.getPageByKey(status, key);
    }

    @Override
    public void insertPage(Page page) {
        pageMapper.insert(page);
    }

    @Override
    public void deletePage(Integer id) {
        pageMapper.deleteById(id);
    }

    @Override
    public void updatePage(Page page) {
        pageMapper.update(page);
    }
    @Override
    public Page getPageById(Integer id) {
        return pageMapper.getPageById(id);
    }

}
