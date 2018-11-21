package com.huyun.sys.dao;


import com.huyun.BaseMapper;
import com.huyun.sys.model.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    //根据UserId 删除角色
    int  deleteByUserId(@Param("userId") Integer userId);
}
