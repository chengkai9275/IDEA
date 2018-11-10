package com.ck.po;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Titel: User
 * @Description: User 用户类
 * @Author: CK
 * @CreateDate: 2018/10/11$ 9:16$
 * @Version: 1.0
 */
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 用户名，账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 性别:男或女
     */
    private String sex;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 激活状态，Y代表激活，N代表未激活
     */
    private String status;
    /**
     * 激活码（要求唯一）
     */
    private String code;


    /**
     * 无参构造方法
     */
    public User() {
    }

    /**
     * 有参构造方法
     *
     * @param uid
     * @param username
     * @param password
     * @param name
     * @param birthday
     * @param sex
     * @param telephone
     * @param email
     * @param status
     * @param code
     * @param registerTime
     */
    public User(Integer uid, String username, String password, String name, Date birthday, String sex, String telephone, String email, String status, String code, Date registerTime) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.code = code;
        this.registerTime = registerTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", registertime=" + registerTime +
                '}';
    }
}
