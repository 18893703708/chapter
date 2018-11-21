package com.huyun.sys.service.impl;


import com.github.pagehelper.PageInfo;
import com.huyun.sys.model.RolePermission;
import com.huyun.sys.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Override
    public List<RolePermission> selectAll() {
        return null;
    }

    @Override
    public RolePermission findByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int insert(RolePermission rolePermission) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(RolePermission rolePermission) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {
        return 0;
    }

    @Override
    public PageInfo<RolePermission> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
        return null;
    }

    @Override
    public List<RolePermission> selectByT(RolePermission rolePermission) {
        return null;
    }

    @Override
    public RolePermission findOne(RolePermission rolePermission) {
        return null;
    }
}
