package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:25
 * @Description:
 */
@Mapper
public interface CategoryMapper {
    List<Category> findAllCategory();

    Integer findCountCategory();

    Category findCategoryById(@Param("id")Integer id);

    List<Category> getCategoiesByArticleId(@Param("aid") Integer aid);
}
