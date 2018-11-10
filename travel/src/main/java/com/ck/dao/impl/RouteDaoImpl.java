package com.ck.dao.impl;

import com.ck.dao.RouteDao;
import com.ck.po.Favorite;
import com.ck.po.Route;
import com.ck.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Titel: RouteDaoImpl
 * @Description: RouteDaoImpl 旅游线路接口实现类
 * @Author: CK
 * @CreateDate: 2018/10/14$ 10:12$
 * @Version: 1.0
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     * 根据cid查询总记录数
     *
     * @param cid
     * @param rname
     * @return int
     */
    @Override
    public int findTotalCount(int cid,String rname) {
        String sql = "select count(*) from tab_route where 1 = 1 ";
        List params = new ArrayList();
        StringBuilder sb = new StringBuilder(sql);
        if(cid != 0){
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if(rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        int count = 0;
        try {
            count = template.queryForObject(sb.toString(), Integer.class, params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return count;
    }

    /**
     * 根据cid，rname, start,pageSize查询当前页的数据集合
     *
     * @param cid
     * @param rname
     * @param start
     * @param pageSize
     */
    @Override
    public List<Route> findByPage(int cid, String rname, int start, int pageSize) {
        String sql = " select * from tab_route where 1 = 1 ";
        List params = new ArrayList();
        StringBuilder sb = new StringBuilder(sql);
        if(cid != 0){
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if(rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(pageSize);
        return template.query(sb.toString(),new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
    }

    /**
     * 查询route详细信息
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOneRoute(int rid) {
        String sql = " select * from tab_route where rid = ? ";
        Route route = null;
        try {
            route = template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
        } catch (DataAccessException e) {

        }
        return route;
    }

}
