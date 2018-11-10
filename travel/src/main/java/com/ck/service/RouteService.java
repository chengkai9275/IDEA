package com.ck.service;

import com.ck.po.PageBean;
import com.ck.po.Route;

import java.util.Date;

/**
 * @Titel: RouteService
 * @Description: RouteService 旅游线路service接口
 * @Author: CK
 * @CreateDate: 2018/10/14$ 10:15$
 * @Version: 1.0
 */
public interface RouteService {
    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
     PageBean<Route> pageQuery(int cid, String rname, int currentPage, int pageSize);

    /**
     * 查询route详细信息
     * @param rid
     * @return
     */
     Route findOneRoute(int rid);


}
