package com.bolife.blogspringboot.mapper;

import com.bolife.blogspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 16:00
 * @Description:
 */
@Mapper
public interface UserMapper {
    public User findUserByUserName(String username);

    void updateUser(@Param("user") User user);
}
