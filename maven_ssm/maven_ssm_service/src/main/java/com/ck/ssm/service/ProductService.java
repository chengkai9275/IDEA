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
     * @throws Exception
     */
    List<Product> findAllPro(Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 根据ID查询产品
     * @param id
     * @return
     * @throws Exception
     */
    Product findProById(String id) throws Exception;

    /**
     * 添加产品
     * @param product
     * @return
     * @throws Exception
     */
    Boolean insertPro(Product product) throws Exception;

    /**
     * 删除产品
     * @param ids
     * @return
     * @throws Exception
     */
    void deleteProById(List<String> ids) throws Exception;
}
