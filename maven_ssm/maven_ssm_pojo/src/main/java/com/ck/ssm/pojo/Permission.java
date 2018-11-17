package com.ck.ssm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Titel: Permission
 * @Description: Permission权限类
 * @Author: CK
 * @CreateDate: 2018/11/15 17:27
 * @Version: 1.0
 */
public class Permission implements Serializable {

    /**
     * 权限Id
     */
    private String id;
    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * 权限路径
     */
    private String url;
    /**
     * 角色
     */
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }
}
