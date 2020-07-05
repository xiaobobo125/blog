package com.bolife.blog.service;

import com.bolife.blog.entity.Menu;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 11:16
 * @Description: 菜单的事务类
 */
public interface MenuService {

    /**
    * @Description: 打印所有的菜单项
    * @Param:
    * @return: 菜单列表
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public List<Menu> listMenu();

    Menu insertMenu(Menu menu) ;

    void deleteMenu(Integer id) ;

    void updateMenu(Menu menu) ;

    Menu getMenuById(Integer id) ;
}
