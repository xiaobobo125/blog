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
}
