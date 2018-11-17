package com.ck.ssm.service;

import com.ck.ssm.pojo.Permission;

import java.util.List;

/**
 * @Titel: PermissionService
 * @Description: PermissionService 权限业务层接口
 * @Author: CK
 * @CreateDate: 2018/11/16 15:17
 * @Version: 1.0
 */
public interface PermissionService {

    /**
     * 查询所有权限
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Permission> findAllPer(Integer pageNum,Integer pageSize)throws Exception;
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
