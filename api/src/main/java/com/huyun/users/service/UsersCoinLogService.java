package com.huyun.users.service;

import com.github.pagehelper.PageInfo;
import com.huyun.base.service.BaseServer;
import com.huyun.users.model.UsersCoinLog;
import com.huyun.users.model.vo.UsersCoinLogBO;

import java.util.List;
import java.util.Map;

public interface UsersCoinLogService extends BaseServer<UsersCoinLog> {
    //查询用户柒略币日志
    PageInfo<UsersCoinLogBO> selectUsersCoinLogList(Integer page, Integer pageSize, Map<String, Object> map);

    //写入日志
    int addUsersCoinLog(Integer userId, Integer coin, String cause);

    //导出需要的集合
    List<UsersCoinLogBO> findByLogList(Map<String, Object> map);
}
