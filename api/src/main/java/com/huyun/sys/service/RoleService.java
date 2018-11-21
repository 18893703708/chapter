package com.huyun.sys.service;

import com.huyun.base.service.BaseServer;
import com.huyun.sys.model.Role;

import java.util.List;
import java.util.Map;


public interface RoleService extends BaseServer<Role> {
    List<Role> selectByUserId(Integer userId);
    List<Role> selectBylikename(Role role);
    /*根据ID删除角色*/
    int deleteRole(Integer roleId);
    Map<String, Object> addPermission2Role(Long roleId, String ids);
}
