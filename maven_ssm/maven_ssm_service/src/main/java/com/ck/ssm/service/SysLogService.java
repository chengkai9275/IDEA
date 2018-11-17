package com.ck.ssm.service;

import com.ck.ssm.pojo.SysLog;

import java.util.List;

/**
 * @Titel: SysLogService
 * @Description: SysLogService 日志业务层接口
 * @Author: CK
 * @CreateDate: 2018/11/17 11:03
 * @Version: 1.0
 */
public interface SysLogService {
    /**
     * 查询所有日志信息
     * @return
     * @throws Exception
     */
    List<SysLog> findAllSysLog(Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 添加新日志
     * @param sysLog
     * @throws Exception
     */
    void insertSysLog(SysLog sysLog) throws Exception;
}
