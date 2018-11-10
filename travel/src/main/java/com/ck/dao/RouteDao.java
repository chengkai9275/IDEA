package com.ck.dao;

import com.ck.po.Favorite;
import com.ck.po.Route;

import java.util.List;

/**
 * @Titel: RouteDao
 * @Description: RouteDao 旅游线路接口
 * @Author: CK
 * @CreateDate: 2018/10/14$ 10:11$
 * @Version: 1.0
 */
public interface RouteDao {
    /**
     * 根据cid查询总记录数
     * @param cid
     * @param rname
     * @return int
     */
     int findTotalCount(int cid,String rname);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return List<Route>
     */
     List<Route> findByPage(int cid , String rname, int start , int pageSize);

    /**
     * 查询route详细信息
     * @param rid
     * @return
     */
     Route findOneRoute(int rid);


}
