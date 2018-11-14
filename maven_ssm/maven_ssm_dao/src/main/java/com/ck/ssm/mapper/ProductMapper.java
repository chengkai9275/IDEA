package com.ck.ssm.mapper;

import com.ck.ssm.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Titel: ProductMapper
 * @Description: ProductMapper 产品
 * @Author: CK
 * @CreateDate: 2018/11/13 19:05
 * @Version: 1.0
 */
public interface ProductMapper {
    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from PRODUCT order by departureTime desc")
    List<Product> findAllPro();

    /**
     * 根据ID查询产品
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    Product findProById(String id);

    /**
     * 添加产品
     * @param product
     * @return
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            " values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    Boolean insertPro(Product product);
}
