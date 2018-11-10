package com.ck.service.impl;

import com.ck.dao.UserDao;
import com.ck.dao.impl.UserDaoImpl;
import com.ck.po.User;
import com.ck.service.UserService;

/**
 * @Titel: UserServiceImpl
 * @Description: UserServiceImpl 用户业务逻辑实现类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 19:10$
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * 通过用户名查询用户
     *
     * @param name
     * @return
     */
    @Override
    public User findUser(String name) {
        return userDao.findUser(name);
    }

    /**
     * 激活用户
     *
     * @param code
     * @return
     */
    @Override
    public boolean activeUser(String code) {
        return userDao.activeUser(code);
    }

    /**
     * 插入用户
     *
     * @param user
     * @return int
     */
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }
}
