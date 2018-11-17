package com.ck.ssm.service;

import com.ck.ssm.pojo.Role;
import com.ck.ssm.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Titel: UserService
 * @Description: UserService 用户登录接口
 * @Author: CK
 * @CreateDate: 2018/11/15 17:16
 * @Version: 1.0
 */
public interface UserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<UserInfo> findAllUser(Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 根据姓名查询用户关联查询角色
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findUserByName(String username) throws Exception;

    /**
     * 根据id查询用户关联查询角色
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findUserById(String id) throws Exception;

    /**
     * 根据id查询用户可关联角色
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findOtherRoleById(String userId) throws Exception;

    /**
     * 保存用户
     * @param userInfo
     * @return
     * @throws Exception
     */
    void insertUser(UserInfo userInfo) throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    void addRoleToUser (String userId,String[] roleIds) throws Exception;

    /**
     * 删除用户
     * @param ids
     * @return
     * @throws Exception
     */
    void deleteUser(List<String> ids) throws Exception;
}
