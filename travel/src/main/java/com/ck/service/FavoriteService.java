package com.ck.service;

import com.ck.po.PageBean;
import com.ck.po.Route;

import java.util.Date;

/**
 * @Titel: FavoriteService
 * @Description: FavoriteService 收藏接口
 * @Author: CK
 * @CreateDate: 2018/10/16$ 11:37$
 * @Version: 1.0
 */
public interface FavoriteService {

    /**
     * 根据id查询线路是否收藏
     * @param rid
     * @param uid
     * @return
     */
    Boolean findFavById(int rid, Integer uid);
    /**
     * 点击添加收藏
     * @param rid
     * @param date
     * @param uid
     * @return
     */
    Boolean addFav(int rid, Date date, Integer uid);

    /**
     * 点击删除收藏
     * @param rid
     * @param uid
     * @return
     */
    Boolean delFav(int rid, Integer uid);

    /**
     * 收藏成功 该线路收藏次数+1
     * @param count
     * @param rid
     * @return
     */
    Boolean addCount(int count,int rid);

    /**
     * 收藏榜分页查询
     * @param currentPage
     * @param pageSize
     * @param routeName
     * @param moneyOne
     * @param moneyTwo
     * @return
     */
    PageBean<Route> collectQuery(int currentPage, int pageSize, String routeName, int moneyOne, int moneyTwo);

    /**
     * 查询我的收藏
     * @param currentPage
     * @param pageSize
     * @param uid
     * @return
     */
    PageBean<Route> findMyFavorite(int currentPage, int pageSize, int uid);
}
