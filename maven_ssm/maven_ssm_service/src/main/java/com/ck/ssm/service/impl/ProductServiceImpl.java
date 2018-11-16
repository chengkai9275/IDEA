package com.ck.ssm.service.impl;

import com.ck.ssm.mapper.ProductMapper;
import com.ck.ssm.pojo.Product;
import com.ck.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * @throws Exception
     */
    public List<Product> findAllPro(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return productMapper.findAllPro();
    }

    /**
     * 根据ID查询产品
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Product findProById(String id) throws Exception {
        return productMapper.findProById(id);
    }

    /**
     * 添加产品
     *
     * @param product
     * @return
     * @throws Exception
     */
    public Boolean insertPro(Product product) throws Exception {
        return productMapper.insertPro(product);
    }

    /**
     * 删除产品
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public void deleteProById(List<String> ids) throws Exception {
        List list = new ArrayList();
        for (String id : ids) {
            list.add(productMapper.findProById(id));
        }
        if(list.size() > 0){
            productMapper.deleteProById(ids);
        }
    }
}
