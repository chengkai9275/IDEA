package com.ck.ssm.test;

import com.ck.ssm.mapper.ProductMapper;
import com.ck.ssm.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Titel: ProductTest
 * @Description: ProductTest 产品测试类
 * @Author: CK
 * @CreateDate: 2018/11/13 19:09
 * @Version: 1.0
 */
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ApplicationContext-dao.xml")
public class ProductTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testFindAll(){
        List<Product> products = productMapper.findAllPro();
        System.out.println(products.size());
    }

    @Test
    public void testFindById(){
        Product pro = productMapper.findProById("F201A89042404387B2BC0853AB1FED9A");
        System.out.println(pro);
    }

    @Test
    public void testInsertPro(){
        Product product = new Product();
        product.setProductNum("itcast-1113");
        product.setProductName("汝州一日游");
        product.setCityName("上号");
        product.setDepartureTime(new Date());
        product.setProductPrice(999.00);
        product.setProductDesc("很不错");
        product.setProductStatus(0);
        Boolean lean = productMapper.insertPro(product);
        System.out.println(lean);
    }

    @Test
    public void testDeleteById(){
        List<String> ids = new ArrayList<String>();
        ids.add("F201A89042404387B2BC0853AB1FED9A");
        productMapper.deleteProById(ids);
    }
}
*/

