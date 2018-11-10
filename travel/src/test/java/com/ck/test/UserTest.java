package com.ck.test;

import com.ck.dao.UserDao;
import com.ck.dao.impl.UserDaoImpl;
import com.ck.po.User;
import com.ck.utils.DateUtils;
import com.ck.utils.Md5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/10/11$ 14:27$
 * @Version: 1.0
 */
public class UserTest {
    @Test
    public void run() throws ParseException {
        String str = "2018-09-10";
        Date date = new Date();
        Date formatDate = DateUtils.getFormatDate(str);

        System.out.println(formatDate);
    }
    @Test
    public void run2(){
        List list = new ArrayList();
        for (int i = 0;i<52;i++){
            list.add(i);
        }
        System.out.println(list);
        list = list.subList(0,50);
        System.out.println(list);
    }

    @Test
    public void run3(){
        String str = "123456";
        String s = null;
        String s1 = null;
        try {
            s = Md5Util.encodeByMd5(str);
            s1=Md5Util.encodeByMd5(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(s);
        System.out.println(s1);

    }

    @Test
    public void run4() throws InvocationTargetException, IllegalAccessException {
        User user = null;
        Map map = new HashMap();
        map.put("username","张三");
        BeanUtils.populate(user,map);
        System.out.println(user);

        User us = new User();
        BeanUtils.populate(us,map);
        System.out.println(us);
    }
}
