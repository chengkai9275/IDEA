package com.ck.ssm.controller;

import com.ck.ssm.pojo.Permission;
import com.ck.ssm.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @Titel: PermissionController
 * @Description: PermissionController 权限
 * @Author: CK
 * @CreateDate: 2018/11/16 15:56
 * @Version: 1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有权限
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllPer/{pageNum}/{pageSize}")
    public ModelAndView findAllPer(@PathVariable Integer pageNum,
                                   @PathVariable Integer pageSize){
        ModelAndView mv = new ModelAndView("permission-list");
        try {
            List<Permission> pers = permissionService.findAllPer(pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(pers);
            mv.addObject("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 根据id查询权限
     * @param id
     * @return
     */
    @RequestMapping("/findPerById/{id}")
    public ModelAndView findPerById(@PathVariable String id){
        ModelAndView mv = new ModelAndView("permission-show");
        try {
            Permission per = permissionService.findPerById(id);
            mv.addObject("per",per);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @RequestMapping("/insertPer")
    public String insertPer(Permission permission){
        if(permission != null){
            try {
                permissionService.insertPer(permission);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllPer/1/4";
    }

    /**
     * 根据id删除权限
     * @param ids
     * @return
     */
    @RequestMapping("/deletePer")
    public String deletePer(String[] ids){
        if(ids.length > 0){
            try {
                permissionService.deletePer(Arrays.asList(ids));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllPer/1/4";
    }
}
