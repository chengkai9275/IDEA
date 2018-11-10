package com.ck.dao;

import com.ck.po.User;

/**
 * @Titel: UserDao
 * @Description: UserDao 用户接口
 * @Author: CK
 * @CreateDate: 2018/10/11$ 19:04$
 * @Version: 1.0
 */
public interface UserDao {
    /**
     * 通过用户名查询用户
     * @param name
     * @return User
     */
    User findUser(String name);

    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean activeUser(String code);

    /**
     * 插入用户
     * @param user
     * @return int
     */
    int insertUser(User user);

    /**
     * 用户登录 通过用户名和密码查询
     * @param user
     * @return
     */
    User findUser(User user);
}
