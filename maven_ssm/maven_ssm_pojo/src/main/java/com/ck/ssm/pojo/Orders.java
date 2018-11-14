package com.ck.ssm.pojo;

import com.ck.ssm.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Titel: Orders
 * @Description: Orders 订单类
 * @Author: CK
 * @CreateDate: 2018/11/13 17:29
 * @Version: 1.0
 */
public class Orders implements Serializable{
    /**
     * 主键
     */
    private String id;
    /**
     * 订单编号 唯一
     */
    private String orderNum;
    /**
     * 订单时间
     */
    private Date orderTime;
    /**
     * 订单时间 字符串
     */
    private String orderTimeStr;
    /**
     * 订单状态 0 未支付 1 已支付
     */
    private int orderStatus;
    /**
     * 订单状态 0 未支付 1 已支付 字符串
     */
    private String orderStatusStr;
    /**
     *
     */
    private int peopleCount;
    private Product product;
    /**
     * 支付方式 0支付宝 1微信 2其他
     */
    private Integer payType;
    /**
     * 支付方式 0支付宝 1微信 2其他
     */
    private String payTypeStr;
    /**
     *
     */
    private String orderDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime != null){
            orderTimeStr = DateUtils.dateStr(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        return orderStatus == 1 ? "已支付" : "未支付";
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType == 0) {
            payTypeStr = "支付宝";
        } else if (payType == 1) {
            payTypeStr = "微信";
        } else if(payType == 2){
            payTypeStr = "其它";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
