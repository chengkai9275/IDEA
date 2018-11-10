package com.ck.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Titel: 名字释义
 * @Description: Filter过滤器作用描述
 * @Author: CK
 * @CreateDate: 2018/10/11$ 9:49$
 * @Version: 1.0
 */
@WebFilter("/*")
public class CharChaterFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将父接口转为子接口
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取提交方式
        String met = request.getMethod();
        //解决post请求中文数据乱码问题
        if ("post".equalsIgnoreCase(met)) {
            request.setCharacterEncoding("utf-8");
        }
        //处理响应乱码
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
