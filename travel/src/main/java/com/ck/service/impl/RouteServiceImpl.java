package com.ck.service.impl;

import com.ck.dao.FavoriteDao;
import com.ck.dao.RouteDao;
import com.ck.dao.RouteImgDao;
import com.ck.dao.SellerDao;
import com.ck.dao.impl.FavoriteDaoImpl;
import com.ck.dao.impl.RouteDaoImpl;
import com.ck.dao.impl.RouteImgDaoImpl;
import com.ck.dao.impl.SellerDaoImpl;
import com.ck.po.*;
import com.ck.service.RouteService;

import java.util.Date;
import java.util.List;

/**
 * @Titel: RouteServiceImpl
 * @Description: RouteServiceImpl 旅游线路service实现类
 * @Author: CK
 * @CreateDate: 2018/10/14$ 10:16$
 * @Version: 1.0
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    /**
     * 根据类别进行分页查询
     *
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, String rname, int currentPage, int pageSize) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合   开始的记录数
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid,rname,start,pageSize);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);

        return pb;
    }

    /**
     * 查询route详细信息
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOneRoute(int rid) {
        Route route = new Route();
        //查询商品信息
        route = routeDao.findOneRoute(rid);
        //查询商家信息
        Seller seller = sellerDao.findSellerById(route.getSid());
        route.setSeller(seller);

        //查询图片信息
        List<RouteImg> imgList = routeImgDao.findImgByRid(rid);
        route.setRouteImgList(imgList);

        return route;
    }

}
