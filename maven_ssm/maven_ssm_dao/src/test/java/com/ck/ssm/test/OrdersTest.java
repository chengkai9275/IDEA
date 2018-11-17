package com.ck.ssm.test;

import com.ck.ssm.mapper.OrdersMapper;
import com.ck.ssm.mapper.ProductMapper;
import com.ck.ssm.mapper.TravellerMapper;
import com.ck.ssm.pojo.Orders;
import com.ck.ssm.pojo.Traveller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Titel: ProductTest
 * @Description: ProductTest 产品测试类
 * @Author: CK
 * @CreateDate: 2018/11/13 19:09
 * @Version: 1.0
 */

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ApplicationContext-dao.xml")
public class OrdersTest {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private TravellerMapper travellerMapper;

    @Test
    public void testFindAll(){
        List<Orders> orders = ordersMapper.findAllOrder();
        System.out.println(orders);
    }

    @Test
    public void testFindTraById(){
        List<Traveller> travellers = travellerMapper.findTraById("0E7231DC797C486290E8713CA3C6ECCC");
        System.out.println(travellers.size());
    }

    @Test
    public void testFindOrderById(){
        Orders order = ordersMapper.findOrderById("0E7231DC797C486290E8713CA3C6ECCC");
        System.out.println(order);
    }
}*/


