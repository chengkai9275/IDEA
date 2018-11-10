package com.ck.dao.impl;

import com.ck.dao.CategoryDao;
import com.ck.po.Category;
import com.ck.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
/**
 * @Titel: CategoryDaoImpl
 * @Description: CategoryDaoImpl 列表分类实现类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 19:05$
 * @Version: 1.0
 */
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category ORDER BY cid asc";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}
