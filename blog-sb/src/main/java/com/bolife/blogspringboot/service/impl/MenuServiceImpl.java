package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.Menu;
import com.bolife.blogspringboot.mapper.MenuMapper;
import com.bolife.blogspringboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:05
 * @Description:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.findAllMenu();
    }
}
