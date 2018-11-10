package cn.itcast.mapper;

import ck.mybatis.mapper.UserMapper;
import ck.mybatis.po.User;
import ck.mybatis.po.UserCustom;
import ck.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/9/4$ 18:24$
 * @Version: 1.0
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        //mybitas配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工,传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     * 用户信息综合查询2
     */
    @Test
    public void testFindUserListES()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sim.parse("2000-1-1");

        userCustom.setBirthday(date);
        userCustom.setAddress("北京");
        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> userListES = mapper.findUserListES(userQueryVo);
        System.out.println(userListES);
        sqlSession.close();
    }

    /**
     * 用户信息综合查询
     * */
    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建userMapper对象  mybatis自动生成 mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();

        //由于使用动态sql，如果不设置某个值，则条件不会拼接在查询条件中
        userCustom.setSex("2");
        userCustom.setUsername("杨");
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        userQueryVo.setUserCustom(userCustom);
        userQueryVo.setIds(ids);
        List<UserCustom> userList = userMapper.findUserList(userQueryVo);
        System.out.println(userList);
        sqlSession.close();
    }

    /**
     * 用户信息综合查询总数
     * */
    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建userMapper对象  mybatis自动生成 mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("2");

        int count = userMapper.findUserCount(userQueryVo);
        System.out.println(count);
        userCustom.setUsername("杨");
        userQueryVo.setUserCustom(userCustom);
        sqlSession.close();
    }

    /**
     * 通过id查找用户 resultMapper 类型
     * */
    @Test
    public void testFindUserByIdResultMapper() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建userMapper对象  mybatis自动生成 mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 通过id查找用户
     * */
    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建userMapper对象  mybatis自动生成 mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 通过 名称模糊查询
     * */
    @Test
    public void testfindUserByName()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userByName = userMapper.findUserByName("1");
        System.out.println(userByName);
        sqlSession.close();
    }

    /**
     * 通过id删除用户
     * */
    @Test
    public void deleteUser()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(10);
        sqlSession.commit();
        sqlSession.close();
    }
}
