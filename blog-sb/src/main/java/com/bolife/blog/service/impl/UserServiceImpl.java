package com.bolife.blog.service.impl;

import com.bolife.blog.entity.User;
import com.bolife.blog.mapper.ArticleMapper;
import com.bolife.blog.mapper.UserMapper;
import com.bolife.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 14:46
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    public UserMapper userMapper;

    @Autowired(required = false)
    public ArticleMapper articleMapper;

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

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<User> listUser() {
        List<User> userList = userMapper.listUser();
        for (int i = 0; i < userList.size(); i++) {
            Integer articleCount = articleMapper.countArticleByUser(userList.get(i).getUserId());
            userList.get(i).setArticleCount(articleCount);
        }
        return userList;
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }


}
