package com.ck.service.impl;

import com.ck.dao.FavoriteDao;
import com.ck.dao.impl.FavoriteDaoImpl;
import com.ck.po.Favorite;
import com.ck.po.PageBean;
import com.ck.po.Route;
import com.ck.service.FavoriteService;

import java.util.Date;
import java.util.List;

/**
 * @Titel: FavoriteServiceImpl
 * @Description: FavoriteServiceImpl 收藏接口实现类
 * @Author: CK
 * @CreateDate: 2018/10/16$ 11:38$
 * @Version: 1.0
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    /**
     * 根据id查询线路是否收藏
     *
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public Boolean findFavById(int rid, Integer uid) {
        Favorite favById = favoriteDao.findFavById(rid, uid);
        if(favById != null){
            return true;
        }
        return false;
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
    public Boolean addFav(int rid, Date date, Integer uid) {
        int count = favoriteDao.addFav(rid,date,uid);
        if(count > 0){
            return true;
        }
        return false;
    }

    /**
     * 点击删除收藏
     *
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public Boolean delFav(int rid, Integer uid) {
        int count = favoriteDao.dleFav(rid, uid);
        if(count > 0){
            return true;
        }
        return false;
    }

    /**
     * 收藏成功 该线路收藏次数+1
     *
     * @param count
     * @param rid
     * @return
     */
    @Override
    public Boolean addCount(int count,int rid) {
        int num = favoriteDao.addCount(count,rid);
        if(num > 0){
            return true;
        }
        return false;
    }

    /**
     * 收藏榜分页查询
     * @param currentPage
     * @param pageSize
     * @param routeName
     * @param moneyOne
     * @param moneyTwo
     * @return
     */
    @Override
    public PageBean<Route> collectQuery(int currentPage, int pageSize, String routeName, int moneyOne, int moneyTwo) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int count = favoriteDao.findTotalCount(routeName, moneyOne, moneyTwo);
        if(count > 50){
            count = 50;
        }
        pb.setTotalCount(count);
        //设置当前页显示的数据集合   开始的索引 每页条目
        int start = (currentPage - 1 ) * pageSize;
        List<Route> collectList = favoriteDao.collectQuery(start,pageSize,routeName,moneyOne,moneyTwo);
        if(collectList.size() > 50){
            collectList.subList(0,50);
        }
        pb.setList(collectList);
        //设置总页数 = 总记录数/每页显示条数
        int totalPage = count % pageSize == 0 ? count / pageSize :(count / pageSize) + 1 ;
        pb.setTotalPage(totalPage);

        return pb;
    }

    /**
     * 查询我的收藏
     *
     * @param currentPage
     * @param pageSize
     * @param uid
     * @return
     */
    @Override
    public PageBean<Route> findMyFavorite(int currentPage, int pageSize, int uid) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int count = favoriteDao.findCount(uid);
        pb.setTotalCount(count);
        int start = (currentPage - 1 ) * pageSize;
        List<Route> collectList = favoriteDao.myFavorite(start,pageSize,uid);
        pb.setList(collectList);
        //设置总页数 = 总记录数/每页显示条数
        int totalPage = count % pageSize == 0 ? count / pageSize :(count / pageSize) + 1 ;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
