package com.ck.ssm.pojo;

import com.ck.ssm.util.DateUtils;

import java.util.Date;

/**
 * @Titel: SysLog
 * @Description: SysLog 日志类
 * @Author: CK
 * @CreateDate: 2018/11/17 10:34
 * @Version: 1.0
 */
public class SysLog {

    /**
     * 日志Id
     */
    private String id;
    /**
     * 访问时间
     */
    private Date visitTime;
    private String visitTimeStr;
    /**
     * 访问用户名
     */
    private String username;
    /**
     * 访问用户 IP
     */
    private String ip;
    /**
     * 访问资源
     */
    private String url;
    /**
     * 访问时长
     */
    private Long executionTime;
    /**
     * 访问方法
     */
    private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        if(visitTime != null){
            visitTimeStr = DateUtils.dateStr(visitTime, "yyyy-MM-dd HH:mm:ss");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", visitTime=" + visitTime +
                ", visitTimeStr='" + visitTimeStr + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }
}
