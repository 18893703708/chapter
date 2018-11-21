package com.huyun.sys.dao;
import com.huyun.BaseMapper;
import com.huyun.sys.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User queryObject(String username);

    //根据条件查询用户列表
    List<User> selectByUserList(@Param("username") String username);
}
