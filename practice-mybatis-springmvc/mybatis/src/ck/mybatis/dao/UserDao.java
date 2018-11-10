package ck.mybatis.dao;

import ck.mybatis.po.User;

/**
 * @Titel: 名字释义
 * @Description: dao开发
 * @Author: CK
 * @CreateDate: 2018/8/31$ 21:11$
 * @Version: 1.0
 */
public interface UserDao {
    //通过ID查询
    public User findUserById(int id) throws Exception;
    //插入用户
    public void insertUser(User user)throws Exception;

}
