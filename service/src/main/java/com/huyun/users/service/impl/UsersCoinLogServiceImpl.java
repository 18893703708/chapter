package com.huyun.users.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyun.users.dao.UsersCoinLogMapper;
import com.huyun.users.model.UsersCoinLog;
import com.huyun.users.model.vo.UsersCoinLogBO;
import com.huyun.users.service.UsersCoinLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UsersCoinLogServiceImpl implements UsersCoinLogService {
    @Autowired
    UsersCoinLogMapper usersCoinLogMapper;
    @Override
    public List<UsersCoinLog> selectAll() {
        return null;
    }

    @Override
    public UsersCoinLog findByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int insert(UsersCoinLog usersCoinLog) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UsersCoinLog usersCoinLog) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {
        return 0;
    }

    @Override
    public PageInfo<UsersCoinLog> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
        return null;
    }

    @Override
    public List<UsersCoinLog> selectByT(UsersCoinLog usersCoinLog) {
        return null;
    }

    @Override
    public UsersCoinLog findOne(UsersCoinLog usersCoinLog) {
        return null;
    }

    @Override
    public PageInfo<UsersCoinLogBO> selectUsersCoinLogList(Integer page, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(page,pageSize);
        List<UsersCoinLogBO> list = usersCoinLogMapper.selectUsersCoinLogList(map);
        return new PageInfo<>(list);
    }

    @Override
    public int addUsersCoinLog(Integer userId, Integer coin, String cause) {
        UsersCoinLog usersCoinLog = new UsersCoinLog();
        usersCoinLog.setUserId(userId);
        usersCoinLog.setCoin(coin);
        usersCoinLog.setCause(cause);
        usersCoinLog.setCreateTime(new Date());
        return usersCoinLogMapper.insert(usersCoinLog);
    }

    @Override
    public List<UsersCoinLogBO> findByLogList(Map<String, Object> map) {
        return usersCoinLogMapper.selectUsersCoinLogList(map);
    }
}
