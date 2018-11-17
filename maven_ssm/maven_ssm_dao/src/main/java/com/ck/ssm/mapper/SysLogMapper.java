package com.ck.ssm.mapper;

import com.ck.ssm.pojo.SysLog;

import java.util.List;

/**
 * @Titel: SysLogMapper
 * @Description: SysLogMapper 日志类
 * @Author: CK
 * @CreateDate: 2018/11/17 10:56
 * @Version: 1.0
 */
public interface SysLogMapper {

    /**
     * 查询所有日志信息
     * @return
     * @throws Exception
     */
    List<SysLog> findAllSysLog() throws Exception;

    /**
     * 添加新日志
     * @param sysLog
     * @throws Exception
     */
    void insertSysLog(SysLog sysLog) throws Exception;
}
