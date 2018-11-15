package com.ck.ssm.mapper;

import com.ck.ssm.pojo.Product;
import org.apache.ibatis.annotations.Delete;
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
    List<Product> findAllPro();

    /**
     * 根据ID查询产品
     * @param id
     * @return
     */
    Product findProById(String id);

    /**
     * 添加产品
     * @param product
     * @return
     */
     Boolean insertPro(Product product);

    /**
     * 删除产品
     * @param ids
     * @return
     */
    Boolean deleteProById(List<String> ids);
}
