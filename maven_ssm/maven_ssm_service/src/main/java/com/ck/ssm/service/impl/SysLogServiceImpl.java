package com.ck.ssm.service.impl;

import com.ck.ssm.mapper.SysLogMapper;
import com.ck.ssm.pojo.SysLog;
import com.ck.ssm.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Titel: SysLogServiceImpl
 * @Description: SysLogServiceImpl 业务层接口实现类
 * @Author: CK
 * @CreateDate: 2018/11/17 11:04
 * @Version: 1.0
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 查询所有日志信息
     *
     * @return
     * @throws Exception
     */
    public List<SysLog> findAllSysLog(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return sysLogMapper.findAllSysLog();
    }

    /**
     * 添加新日志
     *
     * @param sysLog
     * @throws Exception
     */
    public void insertSysLog(SysLog sysLog) throws Exception {
        sysLogMapper.insertSysLog(sysLog);
    }
}
