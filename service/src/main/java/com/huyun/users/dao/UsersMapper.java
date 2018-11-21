package com.huyun.users.dao;

import com.huyun.BaseMapper;
import com.huyun.users.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    List<Users> selectAllUsers(@Param("map") Map<String, Object> map);

    List<Users> selectAllUsersByUsername();
}
