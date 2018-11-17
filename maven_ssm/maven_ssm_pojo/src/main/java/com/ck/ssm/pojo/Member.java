package com.ck.ssm.pojo;

import java.io.Serializable;

/**
 * @Titel: Member
 * @Description: Member 会员
 * @Author: CK
 * @CreateDate: 2018/11/14 21:17
 * @Version: 1.0
 */
public class Member implements Serializable{
    /**
     * Id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 会员
     */
    private String nickname;
    /**
     * 电话
     */
    private String phoneNum;
    /**
     * 邮箱
     */
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
