package com.ck.dao.impl;

import com.ck.dao.UserDao;
import com.ck.po.User;
import com.ck.utils.JdbcUtils;
import javafx.scene.layout.Background;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Titel: UserDaoImpl
 * @Description: UserDaoImpl 用户接口实现类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 19:05$
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     * 通过用户名查询用户
     *
     * @param name
     * @return User
     */
    @Override
    public User findUser(String name) {
        String sql = "select * from tab_user where username = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);
        } catch (Exception e) {
        }
        return user;
    }

    /**
     * 激活用户
     *
     * @param code
     * @return
     */
    @Override
    public boolean activeUser(String code) {
        String sql = "select * from tab_user where code = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
            if (user != null) {
                user.setStatus("Y");
                user.setCode(null);
                sql = "update tab_user set status=?,code=? where uid=?";
                jdbcTemplate.update(sql,user.getStatus(), user.getCode(), user.getUid());
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 插入用户
     *
     * @param user
     * @return int
     */
    @Override
    public int insertUser(User user) {
        String sql = "insert into tab_user values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, user.getUid(), user.getUserName(), user.getPassword(), user.getName(),
                    user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(),
                    user.getRegisterTime(), user.getStatus(), user.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 用户登录
     * 通过用户名和密码查询
     * @param user
     * @return
     */
    @Override
    public User findUser(User user) {
        String sql = "select * from tab_user where username = ? and password = ?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),user.getUserName(),user.getPassword());
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
        return user;
    }

}
