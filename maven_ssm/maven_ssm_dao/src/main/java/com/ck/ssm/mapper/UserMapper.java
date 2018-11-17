package com.ck.ssm.mapper;

import com.ck.ssm.pojo.Role;
import com.ck.ssm.pojo.UserInfo;

import java.util.List;

/**
 * @Titel: UserMapper
 * @Description: UserMapper 用户dao
 * @Author: CK
 * @CreateDate: 2018/11/15 17:24
 * @Version: 1.0
 */
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<UserInfo> findAllUser() throws Exception;

    /**
     * 根据姓名查询用户
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findUserByName(String username) throws Exception;

    /**
     * 根据id查询用户关联角色
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findUserById(String id) throws Exception;

    /**
     * 查询用户可关联角色
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
    Boolean insertUser(UserInfo userInfo) throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    void addRoleToUser (String userId,String roleId) throws Exception;

    /**
     * 根据ID删除用户
     * @param ids
     * @throws Exception
     */
    void deleteUser(List<String> ids) throws Exception;
}
