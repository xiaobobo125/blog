package com.bolife.blogspringboot.service;

import com.bolife.blogspringboot.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 15:52
 * @Description:
 */
public interface UserService {
    User getUserByUserName(String username);

    void updateUser(User user);

    User getUserById(Integer userId);
}
