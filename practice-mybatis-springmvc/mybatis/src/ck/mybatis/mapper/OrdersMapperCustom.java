package ck.mybatis.mapper;

import ck.mybatis.po.*;
import java.util.List;

/**
 * @Titel: OrdersMapperCustom
 * @Description: mapper接口，相当于dao接口 用户管理
 * @Author: CK
 * @CreateDate: 2018/9/11$ 21:11$
 * @Version: 1.0
 */
public interface OrdersMapperCustom{
    /**
     * 查询订单关联查询用户信息
     * @return List<OrdersCustom>
     * @throws Exception
     */
    public List<OrdersCustom> findOrdersUser() throws Exception;

    /**
     * 查询订单关联查询用户信息 ResultMap
     * @return List<Orders>
     * @throws Exception
     */
    public List<Orders> findOrdersUserResultMap() throws Exception;

    /**
     * 查询订单关联查询用户及订单详细信息  OrdersAndOrderDetailResultMap
     * @return List<Orders>
     * @throws Exception
     */
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    /**
     * 查询用户及购买商品信息
     * @return List<User>
     * @throws Exception
     */
    public List<User> findUserAndItemsResultMap() throws Exception;

    /**
     * 查询用户姓名 地址 购买商品名称 购买商品时间 购买商品数量
     * @return List<UserCustom>
     * @throws Exception
     */
    public List<UserCustom> findUserShopTime() throws Exception;

    /**
     * 查询订单关联查询用户延迟加载  用户信息是延迟加载
     * @return List<Orders>
     * @throws Exception
     */
    public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
