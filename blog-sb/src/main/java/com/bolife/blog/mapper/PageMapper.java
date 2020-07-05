package com.bolife.blog.mapper;

import com.bolife.blog.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 18:00
 * @Description:
 */
@Mapper
public interface PageMapper {

    public List<Page> listPage(@Param("status") Integer status);

    Page getPageByKey(@Param(value = "status") Integer status,
                      @Param(value = "key") String key);

    Page getPageById(Integer pageId);

    /**
     * 更新
     *
     * @param page 页面
     * @return 影响行数
     */
    int update(Page page);

    int deleteById(Integer pageId);

    /**
     * 添加
     *
     * @param page 页面
     * @return 影响行数
     */
    int insert(Page page);
}
