package com.huyun.sys.model;


import com.huyun.base.model.BaseModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role_permission")
public class RolePermission extends BaseModel {
    @Id
    @GeneratedValue(generator = "JDBC")
    private  Integer id;
    private  Long roleId;
    private  Long permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
