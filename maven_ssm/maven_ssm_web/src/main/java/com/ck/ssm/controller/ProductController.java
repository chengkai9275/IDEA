package com.ck.ssm.controller;

import com.ck.ssm.pojo.Product;
import com.ck.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Titel: ProductController
 * @Description: ProductController 产品
 * @Author: CK
 * @CreateDate: 2018/11/13 19:42
 * @Version: 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 分页查询所有用户
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    @RequestMapping("/findAllPro/{pageNum}/{pageSize}")
    public ModelAndView findAllPro(@PathVariable int pageNum,
                                   @PathVariable int pageSize){
        ModelAndView mv = new ModelAndView("product-list");
        List<Product> products = productService.findAllPro(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    /**
     * 根据Id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/findProById/{id}")
    public ModelAndView findProById(@PathVariable String id){
        ModelAndView mv = new ModelAndView("product-list");
        if(id != null && !"".equals(id)){
            Product pro = productService.findProById(id);
            mv.addObject("pro",pro);
        }
        return mv;
    }

    /**
     * 插入新用户
     * @param product
     * @return
     */
    @RequestMapping("/insertPro")
    public String insertPro(Product product){
        if(product != null){
            productService.insertPro(product);
        }
        return "redirect:findAllPro/1/4";
    }

    /**
     * 根据Id删除用户
     * @param id
     * @return
     */
    @RequestMapping("/deletePro")
    public String deletePro(String[] id){
        if(id.length > 0){
            productService.deleteProById(Arrays.asList(id));
        }
        return "redirect:findAllPro/1/4";
    }
}
