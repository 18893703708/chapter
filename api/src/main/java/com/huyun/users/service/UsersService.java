package com.huyun.users.service;

import com.github.pagehelper.PageInfo;
import com.huyun.base.service.BaseServer;
import com.huyun.users.model.Users;

import java.util.List;
import java.util.Map;

public interface UsersService extends BaseServer<Users> {

    PageInfo<Users> selectAllUsers(Integer page, Integer pageSize, Map<String, Object> map);
    List<Users> getAllUsersByUsername();

}
