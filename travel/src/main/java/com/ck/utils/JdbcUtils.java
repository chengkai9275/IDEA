package com.ck.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Titel: JDBCUtil
 * @Description: JDBCUtil 工具类 数据库连接池
 * @Author: CK
 * @CreateDate: 2018/9/14$ 11:04$
 * @Version: 1.0
 */
public abstract class JdbcUtils {

    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //得到数据连接池
    public static DataSource getDataSource(){
        return ds;
    }
    //得到连接对象
    public static Connection getConnection() throws SQLException {
       return ds.getConnection();
    }

}
