package com.ck.dao;

import com.ck.po.Favorite;
import com.ck.po.Route;

import java.util.Date;
import java.util.List;

/**
 * @Titel: Favorite
 * @Description: Favorite 收藏接口
 * @Author: CK
 * @CreateDate: 2018/10/15$ 19:16$
 * @Version: 1.0
 */
public interface FavoriteDao {
    /**
     * 通过ID查询是否收藏
     * @param rid
     * @param uid
     * @return
     */
    Favorite findFavById(int rid, int uid);

    /**
     * 点击添加收藏
     * @param rid
     * @param date
     * @param uid
     * @return
     */
    int addFav(int rid, Date date, Integer uid);

    /**
     * 点击添加收藏
     * @param rid

     * @param uid
     * @return
     */
    int dleFav(int rid, Integer uid);

    /**
     * 收藏成功 收藏次数+1
     * @param count
     * @param rid
     * @return
     */
    int addCount(int count,int rid);

    /**
     * 收藏总数查询
     * @param routeName
     * @param moneyOne
     * @param moneyTwo
     * @return
     */
    int findTotalCount(String routeName, int moneyOne, int moneyTwo);

    /**
     * 收藏榜查询
     * @param start
     * @param pageSize
     * @param routeName
     * @param moneyOne
     * @param moneyTwo
     * @return
     */
    List<Route> collectQuery(int start, int pageSize, String routeName, int moneyOne, int moneyTwo);

    /**
     * 查询我的收藏
     * @param uid
     * @return
     */
    int findCount(int uid);

    /**
     * 查询收藏数据
     * @param start
     * @param pageSize
     * @param uid
     * @return
     */
    List<Route> myFavorite(int start, int pageSize, int uid);
}
