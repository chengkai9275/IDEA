package com.ck.ssm.controller;

import com.ck.ssm.pojo.SysLog;
import com.ck.ssm.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/11/17 11:05
 * @Version: 1.0
 */
@Controller
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAllSysLog/{pageNum}/{pageSize}")
    public ModelAndView findAllSysLog(@PathVariable Integer pageNum,
                                      @PathVariable Integer pageSize){
        ModelAndView mv = new ModelAndView("syslog-list");
        try {
            List<SysLog> sysLogs = sysLogService.findAllSysLog(pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(sysLogs);
            mv.addObject("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
