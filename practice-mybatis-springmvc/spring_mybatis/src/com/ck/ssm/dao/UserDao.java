package com.ck.ssm.dao;


import com.ck.ssm.po.User;

/**
 * @Titel: UserDao
 * @Description: dao开发
 * @Author: CK
 * @CreateDate: 2018/8/31$ 21:11$
 * @Version: 1.0
 */
public interface UserDao {
    //通过ID查询
    public User findUserById(int id) throws Exception;

}
