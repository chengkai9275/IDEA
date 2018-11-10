package cn.itcast.dao;

import ck.mybatis.dao.UserDao;
import ck.mybatis.dao.UserDaoImpl;
import ck.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/8/31$ 21:21$
 * @Version: 1.0
 */
public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 加载配置文件 创建工厂
     * */
    @Before
    public void setUp() throws Exception {
        //mybitas配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工,传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 测试 查找方法
     * */
    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
    /**
     * 测试 插入方法
     * */
    @Test
    public void testInsertUser() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setUsername("111");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("2222");
        userDao.insertUser(user);
    }
}
