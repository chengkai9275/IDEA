package ck.mybatis.first;

import ck.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * <p>Titel:</p>
 * <p>Description: java类作用描述</p>
 *
 * @Author: CK
 * @CreateDate: 2018/8/28$ 18:54$
 * @Version: 1.0
 */
public class MybatisFirst {
   
    //根据id查询用户信息,得到一条记录结果
    @Test
    public void findUserByIdTest() throws IOException {
            //mybitas配置文件
            String resource = "SqlMapConfig.xml";
            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //创建会话工,传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
            //通过工厂得到SqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //通过SqlSession操作数据库
            //第一个参数:映射文件中statement的id，等于= namespace+"."+statement的id
            //第二个参数:指定和映射文件中所匹配的parameterType类型的参数
            //sqlSession.selectOne结果就是与映射文件中所匹配的parameterType类型的对象
            //selectOne 查询一条
            User user = sqlSession.selectOne("test.findUserById",31);
            System.out.println(user);
            //释放资源
            sqlSession.close();
    }

    //根据用户名称模糊查询
    @Test
    public void findUserByNameTest() throws IOException {
        //mybitas配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("test.findUserByName", "小");
        System.out.println(list);
        sqlSession.close();
    }

    //添加用户
    @Test
    public void insertUserTest() throws IOException {
        //mybitas配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //插入用户对象
        User user = new User();
        user.setUsername("test111");
        user.setSex("2");
        user.setAddress("杭州");
        user.setBirthday(new Date());
        sqlSession.selectList("test.insertUser",user);
//        sqlSession.commit();
        sqlSession.close();
    }
    //删除用户
    @Test
    public void deleteUserTest() throws IOException {
        //mybitas配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工,传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser",30);
        sqlSession.commit();
        sqlSession.close();
    }
}
