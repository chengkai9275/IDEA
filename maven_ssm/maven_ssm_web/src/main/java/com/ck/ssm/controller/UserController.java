package com.ck.ssm.controller;

import com.ck.ssm.pojo.Role;
import com.ck.ssm.pojo.UserInfo;
import com.ck.ssm.service.RoleService;
import com.ck.ssm.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @Titel: UserController
 * @Description: UserController
 * @Author: CK
 * @CreateDate: 2018/11/16 11:42
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAllUser/{pageNum}/{pageSize}")
    public ModelAndView findAllUser(@PathVariable Integer pageNum,
                                    @PathVariable Integer pageSize) {
        ModelAndView mv = new ModelAndView("user-list");
        try {
            List<UserInfo> userInfos = userService.findAllUser(pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(userInfos);
            mv.addObject("pageInfo", pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 根据Id查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping("findUserById/{id}")
    public ModelAndView findUserById(@PathVariable String id) {
        ModelAndView mv = new ModelAndView("user-show");
        try {
            UserInfo userInfo = userService.findUserById(id);
            mv.addObject("userInfo", userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("/insertUser")
    public String insertUser(UserInfo userInfo) {
        if (userInfo != null) {
            try {
                userService.insertUser(userInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllUser/1/4";
    }

    /**
     * 添加用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(String[] id) {
        if (id.length > 0) {
            try {
                userService.deleteUser(Arrays.asList(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:findAllUser/1/4";
    }

    /**
     * 添加角色界面
     *
     * @param id
     * @return
     */
    @RequestMapping("/addRole/{id}")
    public ModelAndView addRole(@PathVariable String id) {
        ModelAndView mv = new ModelAndView("user-role-add");
        try {
            UserInfo userInfo = userService.findUserById(id);
            List<Role> roles = userService.findOtherRoleById(userInfo.getId());
            mv.addObject("userInfo", userInfo);
            mv.addObject("roles",roles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param ids
     * @return
     */
    @RequestMapping("/addRoleToUser/{userId}")
    public String addRoleToUser(@PathVariable String userId, String[] ids) {
        if (ids.length > 0) {
            try {
                userService.addRoleToUser(userId, ids);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/user/findAllUser/1/4";
    }
}
