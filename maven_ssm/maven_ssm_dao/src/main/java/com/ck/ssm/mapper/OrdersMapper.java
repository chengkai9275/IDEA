package com.ck.ssm.mapper;

import com.ck.ssm.pojo.Orders;

import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: 接口作用描述
 * @Author: CK
 * @CreateDate: 2018/11/13 19:05
 * @Version: 1.0
 */
public interface OrdersMapper {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    List<Orders> findAllOrder() throws Exception;

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
    Boolean deleteOrderById(List<String> ids) throws Exception;
}
