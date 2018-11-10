package com.ck.service;

import com.ck.po.User;

/**
 * @Titel: UserService
 * @Description: UserService 用户业务逻辑
 * @Author: CK
 * @CreateDate: 2018/10/11$ 19:08$
 * @Version: 1.0
 */
public interface UserService {
    /**
     * 通过用户名查询用户
     * @param name
     * @return
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
     * 用户登录
     * @param user
     * @return
     */
    User findUser(User user);
}
