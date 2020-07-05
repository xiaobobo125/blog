package com.bolife.blog.mapper;

import com.bolife.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/5 14:46
 * @Description: 用户的持久层接口
 */
@Mapper
public interface UserMapper {
    /***
     * 插入用户
     * @param user
     * @return
     */
    int insert(User user);

    /***
     * 根据用户名或者email进行查询
     * @param str
     * @return
     */
    User getUserByNameOrEmail(String str) ;

    /***
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);

    /***
     * 根据用户ID获取用户信息
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    User getUserByEmail(String email);

    User getUserByName(String name);

    List<User> listUser();

    void deleteById(Integer id);
}
