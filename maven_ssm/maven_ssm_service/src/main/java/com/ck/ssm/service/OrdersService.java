package com.ck.ssm.service;

import com.ck.ssm.pojo.Orders;

import java.util.List;

/**
 * @Titel: OrdersService
 * @Description: OrdersService 订单业务层接口
 * @Author: CK
 * @CreateDate: 2018/11/14 20:24
 * @Version: 1.0
 */
public interface OrdersService {

    /**
     * 查询所有订单
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Orders> findAllOrder(int pageNum,int pageSize) throws Exception;

    /**
     * 根据Id查询订单
     * @param id
     * @return
     * @throws Exception
     */
    Orders findOrderById(String id) throws Exception;

    /**
     * 根据Id删除订单
     * @param ids
     * @return
     * @throws Exception
     */
    void deleteOrderById(List<String> ids) throws Exception;
}
