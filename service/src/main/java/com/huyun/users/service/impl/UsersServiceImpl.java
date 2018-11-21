package com.huyun.users.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyun.users.dao.UsersMapper;
import com.huyun.users.model.Users;
import com.huyun.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public PageInfo<Users> selectAllUsers(Integer page, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(page,pageSize);
        List<Users> list = usersMapper.selectAllUsers(map);
        return new PageInfo<>(list);
    }

    @Override
    public List<Users> getAllUsersByUsername() {
        return usersMapper.selectAllUsersByUsername();
    }

    @Override
    public List<Users> selectAll() {
        return usersMapper.selectAll();
    }

    @Override
    public Users findByPrimaryKey(String id) {
        return usersMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override

    public int insert(Users users) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Users users) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {
        return 0;
    }

    @Override
    public PageInfo<Users> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Users> selectByT(Users users) {
        return null;
    }

    @Override
    public Users findOne(Users users) {
        return null;
    }
}
