package com.ck.ssm.service.impl;

import com.ck.ssm.mapper.RoleMapper;
import com.ck.ssm.pojo.Permission;
import com.ck.ssm.pojo.Role;
import com.ck.ssm.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Titel: RoleServiceImpl
 * @Description: RoleServiceImpl 业务层接口实现类
 * @Author: CK
 * @CreateDate: 2018/11/16 15:18
 * @Version: 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色
     *
     * @return
     * @throws Exception
     */
    public List<Role> findAllRole(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return roleMapper.findAllRole();
    }

    /**
     * 根据用户Id查询角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<Role> findRoleByUserId(String id) throws Exception {
        return roleMapper.findRoleByUserId(id);
    }

    /**
     * 根据ID查询角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Role findRoleById(String id) throws Exception {
        return roleMapper.findRoleById(id);
    }

    /**
     * 根据角色Id查询角色可关联权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<Permission> findOtherPermission(String id) throws Exception {
        return roleMapper.findOtherPermission(id);
    }

    /**
     * 添加角色
     *
     * @param role
     * @throws Exception
     */
    public void insertRole(Role role) throws Exception {
        roleMapper.insertRole(role);
    }

    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param ids
     */
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String permissionId : ids) {
            roleMapper.addPermissionToRole(permissionId,roleId);
        }
    }

    /**
     * 删除角色
     *
     * @param ids
     * @throws Exception
     */
    public void deleteRole(List<String> ids) throws Exception {
        List list = new ArrayList();
        for (String id : ids) {
            list.add(roleMapper.findRoleById(id));
        }
        if(list.size() > 0){
           roleMapper.deleteRole(ids);
        }
    }
}
