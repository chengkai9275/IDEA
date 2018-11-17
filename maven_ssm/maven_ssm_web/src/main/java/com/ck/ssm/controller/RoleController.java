package com.ck.ssm.controller;

import com.ck.ssm.pojo.Permission;
import com.ck.ssm.pojo.Role;
import com.ck.ssm.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @Titel: RoleController
 * @Description: RoleController 角色
 * @Author: CK
 * @CreateDate: 2018/11/16 15:55
 * @Version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllRole/{pageNum}/{pageSize}")
    public ModelAndView findAllRole(@PathVariable Integer pageNum,
                                    @PathVariable Integer pageSize){
        ModelAndView mv = new ModelAndView("role-list");
        try {
            List<Role> roles = roleService.findAllRole(pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(roles);
            mv.addObject("pageInfo",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 根据ID查询角色
     * @param id
     * @return
     */
    @RequestMapping("/findRoleById/{id}")
    public ModelAndView findRoleById(@PathVariable String id){
        ModelAndView mv = new ModelAndView("role-show");
        try {
            Role role = roleService.findRoleById(id);
            mv.addObject("role",role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 添加角色界面
     * @return
     */
    @RequestMapping("/insertRoleJsp")
    public String insertRoleJsp(){
        return "role-add";
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("/insertRole")
    public String insertRole(Role role){
        if(role != null){
            try {
                roleService.insertRole(role);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllRole/1/4";
    }

    /**
     * 角色添加权限界面
     * @param id
     * @return
     */
    @RequestMapping("/addPermission/{id}")
    public ModelAndView addPermission(@PathVariable String id){
        ModelAndView mv = new ModelAndView("role-permission-add");
        try {
            List<Permission> otherPermission = roleService.findOtherPermission(id);
            mv.addObject("roleId",id);
            mv.addObject("permissions",otherPermission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 角色添加权限
     * @return
     */
    @RequestMapping("/addPermissionToRole/{roleId}")
    public String addPermissionToRole(@PathVariable String roleId,String[] ids){
        if(ids.length > 0){
            roleService.addPermissionToRole(roleId,ids);
        }
        return "redirect:/role/findAllRole/1/4";
    }

    /**
     * 删除角色
     * @param ids
     * @return
     */
    @RequestMapping("/deleteRole")
    public String deleteRole(String[] ids){
        if(ids.length > 0){
            try {
                roleService.deleteRole(Arrays.asList(ids));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllRole/1/4";
    }
}
