package com.ck.ssm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Titel: BCryptPasswordEncoderUtils
 * @Description: BCryptPasswordEncoderUtils 密码加密工具类
 * @Author: CK
 * @CreateDate: 2018/11/16 11:18
 * @Version: 1.0
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 密码加密
     *
     * @param password
     * @return
     */
    public static String encoderPassword(String password) {
        String encode = null;
        if (password != null) {
            encode = bCryptPasswordEncoder.encode(password);
        }
        return encode;
    }

}
