package com.ck.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Titel: DateUtils
 * @Description: DateUtils 日期工具类
 * @Author: CK
 * @CreateDate: 2018/11/13 18:49
 * @Version: 1.0
 */
public class DateUtils {
    /**
     * 日期转换成字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateStr(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 字符串转换成日期
     * @param str
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date strDate(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date parse = sdf.parse(str);
        return parse;
    }
}
