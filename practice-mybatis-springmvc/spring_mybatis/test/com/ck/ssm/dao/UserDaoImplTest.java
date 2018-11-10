package com.ck.ssm.dao;

import com.ck.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Titel: UserDaoImplTest
 * @Description: UserDaoImplTest  测试类
 * @Author: CK
 * @CreateDate: 2018/9/15$ 16:48$
 * @Version: 1.0
 */
public class UserDaoImplTest {
    private ApplicationContext applicationContext;

    //在setUp方法中 得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        //调用方法
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
