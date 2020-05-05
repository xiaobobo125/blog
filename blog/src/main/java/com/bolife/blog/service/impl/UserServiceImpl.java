package com.bolife.blog.service.impl;

import com.bolife.blog.entity.User;
import com.bolife.blog.mapper.UserMapper;
import com.bolife.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 14:46
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    public UserMapper userMapper;

    @Override
    public void insert(User user) {
        user.setUserRegisterTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public User getUserByNameOrEmail(String name) {
        return userMapper.getUserByNameOrEmail(name);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }
}
