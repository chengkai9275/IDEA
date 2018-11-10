package com.ck.dao.impl;

import com.ck.dao.FavoriteDao;
import com.ck.dao.RouteDao;
import com.ck.po.Favorite;
import com.ck.po.Route;
import com.ck.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Titel: FavoriteDaoImpl
 * @Description: FavoriteDaoImpl 收藏接口实现类
 * @Author: CK
 * @CreateDate: 2018/10/15$ 19:17$
 * @Version: 1.0
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    /**
     * 通过ID查询是否收藏
     *
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public Favorite findFavById(int rid, int uid) {
        String sql = "select * from tab_favorite where rid = ? and uid = ?";
        Favorite favorite = null;
        try {
            favorite = template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),rid,uid);
        } catch (DataAccessException e) {

        }
        return favorite;
    }

    /**
     * 点击添加收藏
     *
     * @param rid
     * @param date
     * @param uid
     * @return
     */
    @Override
    public int addFav(int rid, Date date, Integer uid) {
        String sql = " insert into tab_favorite values(?,?,?) ";
        int count = 0;
        try {
            count = template.update(sql, rid, date, uid);
        } catch (DataAccessException e) {
        }
        return count;
    }

    /**
     * 点击添加收藏
     *
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public int dleFav(int rid, Integer uid) {
        String sql = " delete from tab_favorite where rid = ? and uid = ? ";
        int count = 0;
        try {
            count = template.update(sql, rid, uid);
        } catch (DataAccessException e) {
        }
        return count;
    }

    /**
     * 收藏成功 收藏次数+1
     *
     * @param count
     * @param rid
     * @return
     */
    @Override
    public int addCount(int count,int rid) {
        String sql = " update tab_route set count=? where rid = ?";
        int num = 0;
        try {
            num = template.update(sql, count,rid);
        } catch (DataAccessException e) {
        }
        return num;
    }

    /**
     * 收藏总数查询
     *
     * @param routeName
     * @param moneyOne
     * @param moneyTwo
     * @return
     */
    @Override
    public int findTotalCount(String routeName, int moneyOne, int moneyTwo) {
        String sql = " select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if(routeName != null && routeName.length() > 0){
            sb.append(" and rname like ? ");
            params.add("%"+routeName+"%");
        }
        if(moneyOne != 0){
            sb.append(" and price > ? ");
            params.add(moneyOne);
        }
        if(moneyTwo != 0){
            sb.append(" and price < ? ");
            params.add(moneyTwo);
        }
        sb.append(" order by count desc ");

        int count = 0;
        try {
            count = template.queryForObject(sb.toString(), Integer.class, params.toArray());
        } catch (DataAccessException e) {
            return 0;
        }
        return count;
    }

    /**
     * 收藏榜查询
     * @param start
     * @param pageSize
     * @param routeName
     * @param moneyOne
     * @param moneyTwo
     * @return
     */
    @Override
    public List<Route> collectQuery(int start, int pageSize, String routeName, int moneyOne, int moneyTwo) {
        String sql = " select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        if(routeName != null && routeName.length() > 0){
            sb.append(" and rname like ? ");
            params.add("%"+routeName+"%");
        }
        if(moneyOne != 0){
            sb.append(" and price > ? ");
            params.add(moneyOne);
        }
        if(moneyTwo != 0){
            sb.append(" and price < ? ");
            params.add(moneyTwo);
        }
        sb.append(" order by count desc limit ?,? ");
        params.add(start);
        params.add(pageSize);
        List<Route> query = template.query(sb.toString(), new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
        return query;
    }

    /**
     * 查询我的收藏
     *@param uid
     * @return
     */
    @Override
    public int findCount(int uid) {
        String sql = " select count(*) from tab_favorite where uid = ? ";
        int count = 0;
        try {
            count = template.queryForObject(sql, Integer.class, uid);
        } catch (DataAccessException e) {
            return 0;
        }
        return count;
    }

    /**
     * 查询收藏数据
     *
     * @param start
     * @param pageSize
     * @param uid
     * @return
     */
    @Override
    public List<Route> myFavorite(int start, int pageSize, int uid) {
        String sql = " SELECT * FROM tab_route WHERE rid IN(SELECT rid FROM tab_favorite WHERE uid = ?) order by count desc limit ?,? ";
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),uid,start,pageSize);
    }
}
