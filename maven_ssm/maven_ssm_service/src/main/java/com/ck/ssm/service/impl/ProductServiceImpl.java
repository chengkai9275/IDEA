package com.ck.ssm.service.impl;

import com.ck.ssm.mapper.ProductMapper;
import com.ck.ssm.pojo.Product;
import com.ck.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Titel: ProductServiceImpl
 * @Description: ProductServiceImpl 产品业务层实现类
 * @Author: CK
 * @CreateDate: 2018/11/13 19:28
 * @Version: 1.0
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    /**
     * 查询所有产品
     *
     * @param pageNum  页码值
     * @param pageSize 每页条数
     * @return
     */
    public List<Product> findAllPro(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return productMapper.findAllPro();
    }

    /**
     * 根据ID查询产品
     *
     * @param id
     * @return
     */
    public Product findProById(String id) {
        return productMapper.findProById(id);
    }

    /**
     * 添加产品
     *
     * @param product
     * @return
     */
    public Boolean insertPro(Product product) {
        Boolean lean = productMapper.insertPro(product);
        return lean;
    }
}
