package com.bolife.blog.mapper;

import com.bolife.blog.entity.Options;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 12:11
 * @Description:
 */
@Mapper
public interface OptionsMapper {
    public Options getOptions();
}
