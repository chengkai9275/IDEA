package com.ck.ssm.controller;

import com.ck.ssm.pojo.Product;
import com.ck.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
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
     * 分页查询所有产品
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    @RequestMapping("/findAllPro/{pageNum}/{pageSize}")
    public ModelAndView findAllPro(@PathVariable Integer pageNum,
                                   @PathVariable Integer pageSize){
        ModelAndView mv = new ModelAndView("product-list");
        try {
            List<Product> products = productService.findAllPro(pageNum,pageSize);
            PageInfo pageInfo = new PageInfo(products);
            mv.addObject("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 根据Id查询产品
     * @param id
     * @return
     */
    @RequestMapping("/findProById/{id}")
    public ModelAndView findProById(@PathVariable String id){
        ModelAndView mv = new ModelAndView("product-list");
            try {
                Product pro = productService.findProById(id);
                mv.addObject("pro",pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return mv;
    }

    /**
     * 添加产品界面
     * 具备权限才能进入添加产品界面
     * @return
     */
    @RolesAllowed({"ROLE_BUSINESS","ROLE_SUPERADMIN","ROLE_BUSINESS"})
    @RequestMapping("/insertProJsp")
    public String insertProJsp(){
        return "product-add";
    }

    /**
     * 插入新产品
     * @param product
     * @return
     */
    @RequestMapping("/insertPro")
    public String insertPro(Product product){
        if(product != null){
            try {
                productService.insertPro(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllPro/1/4";
    }

    /**
     * 根据Id删除产品
     * 具备权限才能
     * @param id
     * @return
     */
    @RolesAllowed({"ROLE_BUSINESS","ROLE_SUPERADMIN","ROLE_BUSINESS"})
    @RequestMapping("/deletePro")
    public String deletePro(String[] id){
        if(id.length > 0){
            try {
                productService.deleteProById(Arrays.asList(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllPro/1/4";
    }
}
