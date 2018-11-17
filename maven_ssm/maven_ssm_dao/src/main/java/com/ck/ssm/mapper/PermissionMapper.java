package com.ck.ssm.mapper;

import com.ck.ssm.pojo.Permission;

import java.util.List;

/**
 * @Titel: PermissionMapper
 * @Description: PermissionMapper 权限接口
 * @Author: CK
 * @CreateDate: 2018/11/15 18:47
 * @Version: 1.0
 */
public interface PermissionMapper {

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    List<Permission> findAllPer()throws Exception;
    /**
     * 根据角色Id查询权限
     * @param id
     * @return
     * @throws Exception
     */
    List<Permission> findPerByRoleId(String id) throws Exception;

    /**
     * 根据ID查询权限
     * @param id
     * @return
     * @throws Exception
     */
    Permission findPerById(String id) throws Exception;

    /**
     * 添加权限
     * @param permission
     * @throws Exception
     */
    void insertPer(Permission permission) throws Exception;

    /**
     * 根据ID删除权限
     * @param ids
     * @throws Exception
     */
    void deletePer(List<String> ids) throws Exception;
}
