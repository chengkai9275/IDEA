package com.ck.web.servlet;

import com.ck.po.Category;
import com.ck.service.CategoryService;
import com.ck.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Titel: CategoryServlet
 * @Description: CategoryServlet 列表servlet
 * @Author: CK
 * @CreateDate: 2018/10/14$ 8:34$
 * @Version: 1.0
 */
@WebServlet("/categoryServlet/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询所有
        List<Category> cs = service.findAll();
        //2.序列化json返回
        writeValue(cs,response);
    }
}
