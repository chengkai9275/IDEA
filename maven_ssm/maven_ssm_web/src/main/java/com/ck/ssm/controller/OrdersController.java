package com.ck.ssm.controller;

import com.ck.ssm.pojo.Orders;
import com.ck.ssm.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @Titel: OrdersController
 * @Description: OrdersController 订单
 * @Author: CK
 * @CreateDate: 2018/11/14 9:28
 * @Version: 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 分页查询所有订单
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    @RequestMapping("/findAllOrder/{pageNum}/{pageSize}")
    public ModelAndView findAllOrder(@PathVariable Integer pageNum,
                                     @PathVariable Integer pageSize){
        ModelAndView mv = new ModelAndView("orders-list");
        List<Orders> orders = null;
        try {
            orders = ordersService.findAllOrder(pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(orders);
            mv.addObject("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 根据Id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/findOrderById/{id}")
    public ModelAndView findOrderById(@PathVariable String id){
        ModelAndView mv = new ModelAndView("orders-show");
            try {
                Orders order = ordersService.findOrderById(id);
                mv.addObject("order",order);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return mv;
    }

    /**
     * 根据Id删除用户
     * @param ids
     * @return
     */
    @RolesAllowed({"ROLE_SUPERADMIN","ROLE_BUSINESS"})
    @RequestMapping("/deleteOrder")
    public String deletePro(String[] ids){
        if (ids.length > 0){
            try {
                ordersService.deleteOrderById(Arrays.asList(ids));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllOrder/1/4";
    }
}
