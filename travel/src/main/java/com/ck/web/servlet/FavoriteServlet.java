package com.ck.web.servlet;

import com.ck.po.PageBean;
import com.ck.po.Route;
import com.ck.po.User;
import com.ck.service.FavoriteService;
import com.ck.service.RouteService;
import com.ck.service.impl.FavoriteServiceImpl;
import com.ck.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Titel: FavoriteServlet
 * @Description: FavoriteServlet 收藏servlet
 * @Author: CK
 * @CreateDate: 2018/10/16$ 15:58$
 * @Version: 1.0
 */
@WebServlet("/favoriteServlet/*")
public class FavoriteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();
    /**
     * 添加收藏线路
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean flag = false;
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        Date date = new Date();
        if (user != null && user.getUid() != null && !"".equals(user.getUid()) && rid != null && !"".equals(rid)) {
            flag = favoriteService.addFav(Integer.parseInt(rid),date,user.getUid());
            //收藏次数加1
            if(flag){
                int count = routeService.findOneRoute(Integer.parseInt(rid)).getCount() + 1;
                Boolean aBoolean = favoriteService.addCount(count,Integer.parseInt(rid));
            }
        }
        writeValue(flag,response);
    }

    /**
     * 删除收藏线路
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void delFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean flag = false;
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && user.getUid() != null && !"".equals(user.getUid()) && rid != null && !"".equals(rid)) {
            flag = favoriteService.delFav(Integer.parseInt(rid),user.getUid());
            if(flag){
                int count = routeService.findOneRoute(Integer.parseInt(rid)).getCount() - 1;
                favoriteService.addCount(count,Integer.parseInt(rid));
            }
        }
        writeValue(flag,response);
    }

    /**
     * 收藏榜分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void collectQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        //获取线路名称
        String routeName = request.getParameter("route_name");
        if(routeName != null && routeName.length() > 0 && !"null".equals(routeName)){
            routeName = new String(routeName.getBytes("iso-8859-1"),"utf-8");
        }
        //获取金额区间
        int moneyOne = 0;
        int moneyTwo = 0;
        String money1 = request.getParameter("money1");
        if(money1 != null && money1.length() > 0 && !"null".equals(money1)){
            moneyOne = Integer.parseInt(money1);
        }
        String money2 = request.getParameter("money2");
        if(money2 != null && money2.length() > 0 && !"null".equals(money2)){
            moneyTwo = Integer.parseInt(money2);
        }
        //2.处理参数
        //当前页码，如果不传递，则默认为第一页
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0 && !"null".equals(currentPageStr)) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        //每页显示条数，如果不传递，默认每页显示5条记录
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0 && !"null".equals(pageSizeStr)) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 8;
        }
        //3. 调用service查询PageBean对象
        PageBean<Route> pb = favoriteService.collectQuery(currentPage, pageSize,routeName,moneyOne,moneyTwo);

        //4. 将pageBean对象序列化为json，返回
        writeValue(pb, response);
    }

    /**
     * 我的收藏分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void myFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        PageBean<Route> pb = null;
        if (user != null && user.getUid() != null && !"".equals(user.getUid())) {
            //登陆成功
            //1.接收参数
            String currentPageStr = request.getParameter("currentPage");
            String pageSizeStr = request.getParameter("pageSize");
            //当前页码，如果不传递，则默认为第一页
            int currentPage = 0;
            if (currentPageStr != null && currentPageStr.length() > 0 && !"null".equals(currentPageStr)) {
                currentPage = Integer.parseInt(currentPageStr);
            } else {
                currentPage = 1;
            }
            //每页显示条数，如果不传递，默认每页显示12条记录
            int pageSize = 0;
            if (pageSizeStr != null && pageSizeStr.length() > 0 && !"null".equals(pageSizeStr)) {
                pageSize = Integer.parseInt(pageSizeStr);
            } else {
                pageSize = 12;
            }
            pb = favoriteService.findMyFavorite(currentPage,pageSize,user.getUid());
            writeValue(pb,response);
        }else{
            //没有登录
            writeValue(pb,response);
        }
    }
}
