package com.sk.ssm.test;

import com.ck.ssm.service.ProductService;
import com.ck.ssm.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/11/13 19:32
 * @Version: 1.0
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/ApplicationContext-service.xml")
public class ProductServiceTest {

    /*@Autowired
    private ProductService productService;*/

    /*@Test
    public void testFindAll(){
        System.out.println(productService.findAllPro().size());
    }*/

    /*@Test
    public void testFindById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/ApplicationContext-service.xml");
        ProductService productService = ac.getBean("productServiceImpl",ProductService.class);
        System.out.println(productService.findProById("198ADCB68BD04B5EB9B3EB6EA1EDB055"));
    }*/

}
