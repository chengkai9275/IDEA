package com.ck.dao.impl;

import com.ck.dao.RouteImgDao;
import com.ck.po.RouteImg;
import com.ck.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/10/14$ 19:08$
 * @Version: 1.0
 */
public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     * 通过 Id查新图片信息
     *
     * @param rid
     * @return
     */
    @Override
    public List<RouteImg> findImgByRid(int rid) {
        String sql = "SELECT * FROM tab_route_img  WHERE rid = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
    }
}
