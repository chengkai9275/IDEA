package ck.mybatis.jdbc;

import java.sql.*;

/**
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/8/28$ 16:18$
 * @Version: 1.0
 */
public class JdbcTest {
    public static void main(String[] args) {
        //数据库连接
        Connection connection = null;
        //预编译的Statement  使用预编译的Statement提高性能
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        try{
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/db1?characterEncoding=utf-8","root","3344521");
            //定义sql语句？表示占位符
            String sql = "SELECT * FROM user WHERE username = ?";
            //获取预处理Statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数 第一个参数为sql语句中参数的序号，第二个参数为设置的参数值
            preparedStatement.setString(1,"王五");
            //像数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历结果集
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+"--"+resultSet.getString("username"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
