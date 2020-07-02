package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:06
 * @Description:
 */
@Mapper
public interface MenuMapper {
    List<Menu> findAllMenu();
}
