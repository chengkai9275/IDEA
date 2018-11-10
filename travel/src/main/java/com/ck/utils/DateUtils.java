package com.ck.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Titel: DateUtils
 * @Description: DateUtils 日期工具类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 20:09$
 * @Version: 1.0
 */
public class DateUtils {

    /**
     * 获取当前日期
     * @return
     */
    public static Date getDate(){
        Date date = new Date();
        return date;
    }

    /**
     * 时间格式化
     * @return Date
     */
    public static Date getFormatDate(String date) throws ParseException {
        if (date != null) {
            //1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //2.返回字符串即可
            return sdf.parse(date);
        }
        return null;
    }

    /**
     * 时间格式化
     * @return String
     */
    public static String getFormatDate(Date date) throws ParseException {
        if (date != null) {
            //1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //2.返回字符串即可
            return sdf.format(date);
        }
        return "";
    }

}
