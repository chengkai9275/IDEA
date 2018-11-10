package com.ck.dao.impl;

import com.ck.dao.SellerDao;
import com.ck.po.Seller;
import com.ck.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Titel: SellerDaoImpl
 * @Description: SellerDaoImpl 商家接口实现类
 * @Author: CK
 * @CreateDate: 2018/10/14$ 19:31$
 * @Version: 1.0
 */
public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    /**
     * 通过ID查询商家信息
     *
     * @param id
     * @return
     */
    @Override
    public Seller findSellerById(int id) {
        String sql = "select * from tab_seller where sid = ?";
        Seller seller = new Seller();
        try {
            seller = template.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return seller;
    }
}
