package com.ck.ssm.service.impl;

import com.ck.ssm.mapper.OrdersMapper;
import com.ck.ssm.mapper.TravellerMapper;
import com.ck.ssm.pojo.Orders;
import com.ck.ssm.pojo.Traveller;
import com.ck.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/11/14 20:25
 * @Version: 1.0
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 查询所有订单
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<Orders> findAllOrder(int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return ordersMapper.findAllOrder();
    }

    /**
     * 根据Id查询订单
     * @param id
     * @return
     * @throws Exception
     */
    public Orders findOrderById(String id) throws Exception {
        return ordersMapper.findOrderById(id);
    }

    /**
     * 根据Id删除订单
     * @param ids
     * @return
     * @throws Exception
     */
    public void deleteOrderById(List<String> ids) throws Exception {
        List list = new ArrayList();
        for (String id : ids) {
            list.add(ordersMapper.findOrderById(id));
        }
        if(list.size() > 0){
            ordersMapper.deleteOrderById(ids);
        }
    }
}
