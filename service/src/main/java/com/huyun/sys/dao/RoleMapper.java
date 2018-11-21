package com.huyun.sys.dao;

import com.huyun.BaseMapper;
import com.huyun.sys.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectByUserId(Integer userId);
    List<Role> selectBylikename(Role role);
    /*根据ID删除角色*/
    int deleteRole(Integer roleId);
}
