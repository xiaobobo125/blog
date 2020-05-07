package com.bolife.blog.service;

import com.bolife.blog.entity.User;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 14:43
 * @Description: 用户的业务层
 */
public interface UserService {

    /***
     * 插入用户信息
     * @param user
     * @return
     */
    public void insert(User user);

    /***
     * 根据用户名或email获取用户
     * @param name
     * @return
     */
    public User getUserByNameOrEmail(String name);

    /***
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /***
     * 根据ID获取用户
     * @param articleUserId
     * @return
     */
    User getUserById(Integer articleUserId);

    void deleteUser(Integer id);

    List<User> listUser();

    User getUserByName(String name);

    User getUserByEmail(String email);
}
