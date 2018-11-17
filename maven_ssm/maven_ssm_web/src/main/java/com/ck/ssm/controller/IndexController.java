package com.ck.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/11/17 10:38
 * @Version: 1.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * 访问首页
     * @return
     */
    @RequestMapping("/main")
    public String openMain(){
        return "main";
    }
}
