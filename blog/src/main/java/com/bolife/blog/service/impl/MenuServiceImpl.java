package com.bolife.blog.service.impl;

import com.bolife.blog.entity.Menu;
import com.bolife.blog.mapper.MenuMapper;
import com.bolife.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 11:17
 * @Description:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired(required = false)
    private MenuMapper menuMapper;
    @Override
    public List<Menu> listMenu() {
        List<Menu> menus = menuMapper.listMenu();
        return menus;
    }
    @Override
    public Menu insertMenu(Menu menu) {
        menuMapper.insert(menu);
        return menu;
    }

    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteById(id);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.update(menu);
    }

    @Override
    public Menu getMenuById(Integer id) {
        return menuMapper.getMenuById(id);
    }
}
