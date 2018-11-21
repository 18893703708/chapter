package com.huyun.sys.dao;

import com.huyun.BaseMapper;
import com.huyun.sys.model.RolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    /*根据角色Id删除*/
    int deleteByRid(Long id);
}
