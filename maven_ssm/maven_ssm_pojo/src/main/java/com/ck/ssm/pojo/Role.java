package com.ck.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Titel: Role
 * @Description: Role 角色类
 * @Author: CK
 * @CreateDate: 2018/11/15 17:27
 * @Version: 1.0
 */
public class Role implements Serializable {
    /**
     * 角色Id
     */
    private String id;
    /**
     * 角色名字
     */
    private String roleName;
    /**
     * 角色详情
     */
    private String roleDesc;
    /**
     * 角色权限
     */
    private List<Permission> permissions;
    /**
     * 用户
     */
    private List<UserInfo> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}
