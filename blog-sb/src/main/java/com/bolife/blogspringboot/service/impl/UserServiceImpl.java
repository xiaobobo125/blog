package com.bolife.blogspringboot.service.impl;

import com.bolife.blogspringboot.entity.User;
import com.bolife.blogspringboot.mapper.UserMapper;
import com.bolife.blogspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 15:52
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

}
