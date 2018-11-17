package com.ck.ssm.service.impl;

import com.ck.ssm.mapper.UserMapper;
import com.ck.ssm.pojo.Permission;
import com.ck.ssm.pojo.Role;
import com.ck.ssm.pojo.UserInfo;
import com.ck.ssm.service.UserService;
import com.ck.ssm.util.BCryptPasswordEncoderUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Titel: UserServiceImpl
 * @Description: UserServiceImpl 用户登录service实现类
 * @Author: CK
 * @CreateDate: 2018/11/15 17:16
 * @Version: 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAllUser(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.findAllUser();
    }

    /**
     * 根据姓名查询用户
     *
     * @param username
     * @return
     * @throws Exception
     */
    public UserInfo findUserByName(String username) throws Exception {
        return userMapper.findUserByName(username);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfo findUserById(String id) throws Exception {
        return userMapper.findUserById(id);
    }

    /**
     * 根据id查询用户可关联角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Role> findOtherRoleById(String userId) throws Exception {
        List<Role> roles = userMapper.findOtherRoleById(userId);
        return roles;
    }

    /**
     * 添加新用户
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    public void insertUser(UserInfo userInfo) throws Exception {
        userInfo.setPassword(BCryptPasswordEncoderUtils.encoderPassword(userInfo.getPassword()));
        userMapper.insertUser(userInfo);
        String userId = userMapper.findUserByName(userInfo.getUsername()).getId();
        String roleId = "6B29A7F617AC4E33A40FC2A3F3EFD013";
        userMapper.addRoleToUser(userId,roleId);
    }

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userMapper.addRoleToUser(userId,roleId);
        }

    }

    /**
     * 删除用户
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public void deleteUser(List<String> ids) throws Exception {
        List list = new ArrayList();
        for (String id : ids) {
            list.add(userMapper.findUserById(id));
        }
        if(list.size() > 0){
            userMapper.deleteUser(ids);
        }
    }

    /**
     * 登录验证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userMapper.findUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //强大构造 判断账户 是否可用..
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 1 ? true : false, true, true,
                true, getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 获取角色权限
     * @param roles
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
        }
        return list;
    }
}
