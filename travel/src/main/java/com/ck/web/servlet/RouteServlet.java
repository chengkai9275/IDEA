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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Titel: RouteServlet
 * @Description: RouteServlet 旅游线路servlet
 * @Author: CK
 * @CreateDate: 2018/10/14$ 10:24$
 * @Version: 1.0
 */
@WebServlet("/routeServlet/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();
    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        String rname = request.getParameter("rname");
        if(rname != null && rname.length() > 0 && !"null".equals(rname)) {
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }
        //类别id
        int cid = 0;
        //2.处理参数
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
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
            pageSize = 5;
        }

        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, rname, currentPage, pageSize);

        //4. 将pageBean对象序列化为json，返回
        writeValue(pb, response);
    }

    /**
     * 查询商品详细
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOneRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        Route route = new Route();
        if (rid != null && !"".equals(rid)) {
            route = routeService.findOneRoute(Integer.valueOf(rid));
        }
        writeValue(route, response);
    }

    /**
     * 判断是否收藏线路
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean flag = false;
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");

        if (user != null && user.getUid() != null && !"".equals(user.getUid()) && rid != null && !"".equals(rid) ) {
            flag = favoriteService.findFavById(Integer.parseInt(rid),user.getUid());
        }
        writeValue(flag,response);
    }




}
