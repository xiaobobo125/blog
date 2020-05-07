package com.bolife.blog.mapper;

import com.bolife.blog.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 11:18
 * @Description: 菜单的持久层接口
 */
@Mapper
public interface MenuMapper {
    
    /**
    * @Description: 获取所有的菜单列表
    * @return:菜单列表
    * @Author: Mr.BoBo
    * @Date: 2020/5/5
    */
    public List<Menu> listMenu();
    /**
     * 删除
     *
     * @param menuId 菜单ID
     * @return 影响行数
     */
    int deleteById(Integer menuId);

    /**
     * 添加
     * @param menu 菜单
     * @return 影响行数
     */
    int insert(Menu menu);

    /**
     * 根据ID查询
     *
     * @param menuId 菜单ID
     * @return 菜单
     */
    Menu getMenuById(Integer menuId);

    /**
     * 更新
     *
     * @param menu 菜单
     * @return 影响行数
     */
    int update(Menu menu);
}
