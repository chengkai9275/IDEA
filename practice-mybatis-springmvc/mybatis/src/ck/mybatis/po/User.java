package ck.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Titel: User
 * @Description: 用户类
 * @Author: CK
 * @CreateDate: 2018/8/28$ 18:45$
 * @Version: 1.0
 */
public class User implements Serializable {

    /**
     * 用户id
     */
    private int id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
   private Date birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户创建的订单列表
     * */
    private List<Orders> ordersList;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", orders=" + ordersList +
                '}';
    }

    public List<Orders> getOrders() {
        return ordersList;
    }

    public void setOrders(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
