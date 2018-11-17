package com.ck.ssm.service.impl;

import com.ck.ssm.mapper.PermissionMapper;
import com.ck.ssm.pojo.Permission;
import com.ck.ssm.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Titel: 名字释义
 * @Description: java类作用描述
 * @Author: CK
 * @CreateDate: 2018/11/16 15:18
 * @Version: 1.0
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 查询所有权限
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<Permission> findAllPer(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return permissionMapper.findAllPer();
    }

    /**
     * 根据角色Id查询权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<Permission> findPerByRoleId(String id) throws Exception {
        return permissionMapper.findPerByRoleId(id);
    }

    /**
     * 根据ID查询权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Permission findPerById(String id) throws Exception {
        return permissionMapper.findPerById(id);
    }

    /**
     * 添加权限
     *
     * @param permission
     * @throws Exception
     */
    public void insertPer(Permission permission) throws Exception {
        permissionMapper.insertPer(permission);
    }

    /**
     * 根据ID删除权限
     *
     * @param ids
     * @throws Exception
     */
    public void deletePer(List<String> ids) throws Exception {
        List list = new ArrayList();
        for (String id : ids) {
            Permission per = permissionMapper.findPerById(id);
            list.add(per);
        }
        if(list.size() > 0){
            permissionMapper.deletePer(ids);
        }
    }
}
