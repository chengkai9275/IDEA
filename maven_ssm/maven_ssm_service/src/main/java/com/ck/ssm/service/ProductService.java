package com.ck.ssm.service;

import com.ck.ssm.pojo.Product;
import java.util.List;

/**
 * @Titel: ProductService
 * @Description: ProductService 产品业务层接口
 * @Author: CK
 * @CreateDate: 2018/11/13 19:27
 * @Version: 1.0
 */
public interface ProductService {

    /**
     * 查询所有产品
     * @param pageNum 页码值
     * @param pageSize 每页条数
     * @return
     */
    List<Product> findAllPro(int pageNum,int pageSize);

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
