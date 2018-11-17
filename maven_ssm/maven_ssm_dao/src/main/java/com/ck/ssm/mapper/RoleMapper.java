package com.ck.ssm.mapper;

import com.ck.ssm.pojo.Permission;
import com.ck.ssm.pojo.Role;

import java.util.List;

/**
 * @Titel: RoleMapper
 * @Description: RoleMapper 角色接口
 * @Author: CK
 * @CreateDate: 2018/11/15 18:47
 * @Version: 1.0
 */
public interface RoleMapper {

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    List<Role> findAllRole() throws Exception;

    /**
     * 根据用户Id查询角色关联权限
     * @param id
     * @return
     * @throws Exception
     */
    List<Role> findRoleByUserId(String id) throws Exception;

    /**
     * 根据Id查询角色
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
     * @param permissionId
     * @param roleId
     */
    void addPermissionToRole(String permissionId, String roleId);

    /**
     * 删除角色
     * @param ids
     * @throws Exception
     */
    void deleteRole(List<String> ids) throws Exception;


}
