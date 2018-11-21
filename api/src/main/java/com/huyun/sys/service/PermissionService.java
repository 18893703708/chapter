package com.huyun.sys.service;



import com.huyun.base.service.BaseServer;
import com.huyun.model.JsonTreeData;
import com.huyun.sys.model.Permission;

import java.util.List;


public interface PermissionService extends BaseServer<Permission> {
    List<JsonTreeData> selectPermissionByUserId(Integer userId);
    //查询所有权限
    List<Permission> findPermissionList();
    /*根据角色ID查询权限信息*/
    List<Permission> selectPerssionByroleId(Long roleId);

}
