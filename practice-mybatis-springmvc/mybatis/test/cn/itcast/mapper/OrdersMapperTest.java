package cn.itcast.mapper;

import ck.mybatis.mapper.OrdersMapperCustom;
import ck.mybatis.mapper.UserMapper;
import ck.mybatis.po.Orders;
import ck.mybatis.po.OrdersCustom;
import ck.mybatis.po.User;
import ck.mybatis.po.UserCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/9/11$ 20:28$
 * @Version: 1.0
 */
public class OrdersMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        //mybitas配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工,传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //查询订单关联查询用户信息
    @Test
    public void testFindOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);

        List<OrdersCustom> list = mapper.findOrdersUser();
        System.out.println(list);
        sqlSession.close();
    }

    //查询订单关联查询用户信息 ResultMap
    @Test
    public void testFindOrdersUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> list = mapper.findOrdersUserResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    //查询订单关联查询用户及订单详细信息 OrdersAndOrderDetailResultMap
    @Test
    public void testFindOrdersAndOrderDetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> list = mapper.findOrdersAndOrderDetailResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    //查询用户及购买商品信息
    @Test
    public void testFindUserAndItemsResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);

        List<User> list = mapper.findUserAndItemsResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    //查询用户姓名 地址 购买商品名称 购买商品时间 购买商品数量
    @Test
    public void testFindUserShopTime() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);

        List<UserCustom> list = mapper.findUserShopTime();
        System.out.println(list);
        sqlSession.close();
    }

    //查询订单关联查询用户信息延迟加载  用户信息是延迟加载
    @Test
    public void testFindOrdersUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);

        //查询订单信息单表
        List<Orders> list = mapper.findOrdersUserLazyLoading();
        //遍历上边的订单列表
        for (Orders orders : list) {
            //执行getUser()去查询用户信息，这里实现按需加载
            User user = orders.getUser();
            System.out.println(user);
        }
    }

    //一级缓存测试
    @Test
    public void testCache1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //第一次发起请求查询id为1的用户
        User user1 = mapper.findUserById(1);
        System.out.println(user1);

        //如果sqlsession执行commit操作，清空一级缓存，目的是为了让缓存中存储新的信息，避免脏读
        //创建更新对象
//        user1.setUsername("测试杨户23");
//        mapper.updateUser(user1);
//        sqlSession.commit();

        //第二次发起请求查询id为1的用户
        User user2 = mapper.findUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }

    //二级缓存测试
    @Test
    public void testCache2() throws Exception {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        //第一次发起请求查询id为1的用户
        User user1 = mapper1.findUserById(1);
        System.out.println(user1);
        //执行关闭操作 将sqlsession中的数据写入到二级缓存区域
        sqlSession1.close();

        //执行commit操作
//        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
//        User user = mapper3.findUserById(1);
//        System.out.println(user);
//        user.setUsername("测试杨110");
//        mapper3.updateUser(user);
//        //执行提交情况usermapper下的二级缓存
//        sqlSession3.commit();
//        sqlSession3.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        //第二次发起请求查询id为1的用户
        User user2 = mapper2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();




        //如果sqlsession执行commit操作，清空一级缓存，目的是为了让缓存中存储新的信息，避免脏读
        //创建更新对象
//        user1.setUsername("测试杨户23");
//        mapper.updateUser(user1);
//        sqlSession.commit();


    }
}
