package com.huyun.sys.dao;

import com.huyun.BaseMapper;
import com.huyun.sys.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectByUserId(Integer userId);
    /*查询所有并根据sort排序*/
    List<Permission> findlist();
    /*根据角色ID查询权限信息*/
    List<Permission> selectPerssionByroleId(Long roleId);
    /*根据ID删除*/
    int deletePermission(Integer permissionId);
}
