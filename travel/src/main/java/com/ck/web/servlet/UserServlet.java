package com.ck.web.servlet;

import com.ck.po.ResultInfo;
import com.ck.po.User;
import com.ck.service.UserService;
import com.ck.service.impl.UserServiceImpl;
import com.ck.utils.DateUtils;
import com.ck.utils.Md5Util;
import com.ck.utils.UuidUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

/**
 * @Titel: 名字释义
 * @Description: servlet类作用描述
 * @Author: CK
 * @CreateDate: 2018/10/12$ 9:37$
 * @Version: 1.0
 */
@WebServlet("/userServlet/*")
public class UserServlet extends BaseServlet {

    /**
     * 抽取公共变量
     */
    private UserService userService = new UserServiceImpl();
    private ResultInfo info = new ResultInfo();

    /**
     * 模板方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void model(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 注册方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        String check = request.getParameter("check");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        boolean flag = equalsCode(checkcode_server, check, response);
        if (!flag) {
            return;
        }
        //创建对象
        User user = new User();
        try {
            //封装参数
            user.setUserName(request.getParameter("username"));
            //加密密码
            user.setPassword(Md5Util.encodeByMd5(request.getParameter("password")));
            user.setName(request.getParameter("name"));
            user.setBirthday(DateUtils.getFormatDate(request.getParameter("birthday")));
            user.setSex(request.getParameter("sex"));
            user.setTelephone(request.getParameter("telephone"));
            user.setEmail(request.getParameter("email"));
            user.setRegisterTime(DateUtils.getDate());
            user.setStatus("N");
            user.setCode(UuidUtil.getUuid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user.getUserName() != null && user.getPassword() != null && user.getName() != null) {
            int i = userService.insertUser(user);
            if (i == 1) {
                //注册成功
                info.setFlag(true);
                String content = "<a href='localhost:8080/travel/userServlet/active?code=" + user.getCode() + "'>点击激活【旅游网】</a>";
                System.out.println(content);
            } else {
                //注册失败
                info.setFlag(false);
                info.setErrorMsg("注册失败");
            }
        }
        writeValue(info, response);
    }

    /**
     * 检测名字可用方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        String username = request.getParameter("username");
        //判断参数是否为空
        if (username != null && !"".equals(username)) {
            //调用UserService 查询数据库
            User user = userService.findUser(username);
            //判断查询结果
            if (user != null) {
                info.setFlag(false);
            } else {
                info.setFlag(true);
            }
            writeValue(info, response);
        }
    }

    /**
     * 检测验证码方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String check = request.getParameter("check");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        if (checkcode_server != null && checkcode_server.equalsIgnoreCase(check)) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
        }
        writeValue(info, response);
    }

    /**
     * 获取验证码方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0, 0, width, height);

        //产生4个随机验证码，12Ey
        String checkCode = getCheckCode();
        //将验证码放入HttpSession中
        request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        //向图片上写入验证码
        g.drawString(checkCode, 15, 25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    /**
     * 产生4位随机字符串
     */
    private String getCheckCode() {
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 激活用户方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取激活码
        String code = request.getParameter("code");
        if (code != null) {
            //2.调用service完成激活
            boolean flag = userService.activeUser(code);

            //3.判断标记
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功,请<a href='../login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            writeStr(msg,response);
        }
    }

    /**
     * 登录方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        boolean flag = equalsCode(checkcode_server, check, response);
        if (!flag) {
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        try {
            user.setUserName(username);
            user.setPassword(Md5Util.encodeByMd5(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        User us = userService.findUser(user);
        //4.判断用户对象是否为null
        if (us == null) {
            //用户名密码或错误
            info.setFlag(false);
            info.setErrorMsg("用户名密码或错误");
        }
        //5.判断用户是否激活
        if (us != null && !"Y".equals(us.getStatus())) {
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活");
        }
        //6.判断登录成功
        if (us != null && "Y".equals(us.getStatus())) {
            String auto_login = request.getParameter("auto");
            if(auto_login != null && auto_login != ""){

                Cookie cookie = new Cookie("auto_login",us.getUserName()+"-"+us.getPassword());
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(cookie);
            }
            //登录成功标记
            request.getSession().setAttribute("user", us);
            //登录成功
            info.setFlag(true);
        }
        writeValue(info, response);
    }

    /**
     * 查询单个对象
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取登录用户
        User user = (User) request.getSession().getAttribute("user");
            //将user写回客户端
        writeValue(user, response);

    }

    /**
     * 退出方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);
        //消除session
        request.getSession().invalidate();
        request.getSession().setAttribute("us",user);
        //清除cookie
        Cookie cookie = new Cookie("auto_login",null);
        cookie.setMaxAge(0);

        User us = (User) request.getSession().getAttribute("us");
        System.out.println(us);

        //2.跳转登录页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 回显数据方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void echoData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("us");
        if(user != null && user.getUserName() != null){
            writeValue(user,response);
        }

    }


    /**
     * 校验验证码
     *
     * @param checkcode_server
     * @param check
     * @param response
     * @return
     * @throws IOException
     */
    public boolean equalsCode(String checkcode_server, String check, HttpServletResponse response) throws IOException {
        if (checkcode_server != null && !checkcode_server.equalsIgnoreCase(check)) {
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            writeValue(info, response);
            return false;
        }
        return true;
    }

}

