package com.ck.ssm.service;

import com.ck.ssm.pojo.Permission;
import com.ck.ssm.pojo.Role;

import java.util.List;

/**
 * @Titel: RoleService
 * @Description: RoleService 角色业务层接口
 * @Author: CK
 * @CreateDate: 2018/11/16 15:17
 * @Version: 1.0
 */
public interface RoleService {
    /**
     * 查询所有角色
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Role> findAllRole(Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 根据用户Id查询角色关联权限
     * @param id
     * @return
     * @throws Exception
     */
    List<Role> findRoleByUserId(String id) throws Exception;

    /**
     * 根据ID查询角色关联权限
     * @param id
     * @return
     * @throws Exception
     */
    Role findRoleById(String id) throws Exception;

    /**
     * 根据角色Id查询角色可关联权限
     * @param id
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermission(String id) throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    void insertRole(Role role) throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(String roleId, String[] ids);

    /**
     * 删除角色
     * @param ids
     * @throws Exception
     */
    void deleteRole(List<String> ids) throws Exception;

}
