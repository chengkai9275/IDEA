package com.ck.ssm.mapper;

import com.ck.ssm.po.User;
import com.ck.ssm.po.UserExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Titel: UserMapperTest
 * @Description: UserMapperTest  测试类
 * @Author: CK
 * @CreateDate: 2018/9/15$ 19:08$
 * @Version: 1.0
 */
public class UserMapperTest {

    private ApplicationContext applicationContext;
    private UserMapper userMapper;
    //在setUp方法中 得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
         userMapper = (UserMapper) applicationContext.getBean("userMapper");
    }

    /**
     * 根据ID查询用户
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {
        User user = userMapper.selectByPrimaryKey(2);
    }

    /**
     * 根据姓名查询用户
     * @throws Exception
     */
    @Test
    public void testFindUserByName() throws Exception {

        UserExample  userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo("虚竹");
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users);
    }

    /**
     * 查询所有用户信息
     * @throws Exception
     */
    @Test
    public void testQueryAllUser() throws Exception {
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);

    }

    @Test
    public void testConditionQuery() throws Exception{

    }

}
