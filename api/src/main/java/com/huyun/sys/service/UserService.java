package com.huyun.sys.service;

import com.huyun.base.service.BaseServer;
import com.huyun.sys.model.User;

import java.util.Map;


public interface UserService extends BaseServer<User> {
    User queryObject(String account);

    int insert();
    //用户角色
    Map<String, Object> addRoleUser(Integer userId, String ids);

    //根据账号密码查询（修改密码时用到）
    User findByAccountAndPwd(String account, String pwd);
}
