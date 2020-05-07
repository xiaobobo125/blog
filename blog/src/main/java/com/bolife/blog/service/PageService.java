package com.bolife.blog.service;


import com.bolife.blog.entity.Page;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 17:57
 * @Description:
 */
public interface PageService {

    public List<Page> listPage(Integer status);

}
