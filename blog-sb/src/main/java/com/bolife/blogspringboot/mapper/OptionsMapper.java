package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.Options;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/6/30 15:56
 * @Description:
 */
@Mapper
public interface OptionsMapper {
    public Options findOptions();
}
