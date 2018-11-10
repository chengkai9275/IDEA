package com.ck.web.filter;

import com.ck.po.User;
import com.ck.service.UserService;
import com.ck.service.impl.UserServiceImpl;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Titel: AutoLoginFilter
 * @Description: AutoLoginFilter 自动登录
 * @Author: CK
 * @CreateDate: 2018/10/12$ 18:54$
 * @Version: 1.0
 */
@WebFilter("/login.html")
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Cookie[] cookies = request.getCookies();
        String str = "auto_login";
        String username = null;
        String password = null;
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if(str.equals(cookie.getName())){
                    String[] strings = cookie.getValue().split("-");
                    username = strings[0];
                    password = strings[1];
                }
            }
        }

        if(username != null&& password != null){
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);

            UserService userService = new UserServiceImpl();
            User us = userService.findUser(user);
            if(us != null){
                request.getSession().setAttribute("user",us);
                response.sendRedirect(request.getContextPath() + "/index.html");
            }
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
