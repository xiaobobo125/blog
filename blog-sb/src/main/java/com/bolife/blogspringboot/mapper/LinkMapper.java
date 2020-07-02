package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Link;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 14:00
 * @Description:
 */
@Mapper
public interface LinkMapper {
    List<Link> findAllLink();

    Integer findCountLink();
}
