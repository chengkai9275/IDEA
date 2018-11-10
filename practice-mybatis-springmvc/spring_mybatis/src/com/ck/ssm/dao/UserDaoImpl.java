package com.ck.ssm.dao;


import com.ck.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @Titel: UserDaoImpl
 * @Description: UserDaoImpl  dao接口实现类
 * @Author: CK
 * @CreateDate: 2018/8/31$ 21:13$
 * @Version: 1.0
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    /**
     * 通过id查找用户方法
     * */
    @Override
    public User findUserById(int id) throws Exception {

        //继承SqlSessionDaoSupport 通过this.getSqlSession() 得到sqlsession
        SqlSession sqlSession = this.getSqlSession();

        User user = sqlSession.selectOne("test.findUserById", id);
        return user;
    }

}
