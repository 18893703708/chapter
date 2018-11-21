package com.huyun.sys.service.impl;


import com.github.pagehelper.PageInfo;
import com.huyun.model.Attributes;
import com.huyun.model.JsonTreeData;
import com.huyun.sys.dao.PermissionMapper;
import com.huyun.sys.model.Permission;
import com.huyun.sys.service.PermissionService;
import com.huyun.utils.TreeNodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    protected PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public Permission findByPrimaryKey(String id) {
        return permissionMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int updateByPrimaryKey(Permission permission) {
        return permissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {
        for(String permissionId : id){
            permissionMapper.deleteByPrimaryKey(Integer.parseInt(permissionId));
        }
        return 1;
    }

    @Override
    public PageInfo<Permission> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Permission> selectByT(Permission permission) {
        return null;
    }

    @Override
    public Permission findOne(Permission permission) {
        return null;
    }


    //左边菜单绑定
    @Override
    public List<JsonTreeData> selectPermissionByUserId(Integer userId) {
        List<Permission> permissionList = null;

        if(userId==0){
            permissionList=permissionMapper.selectAll();
        }else{
            permissionList=permissionMapper.selectByUserId(userId);
        }
        List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
        for (Permission perm : permissionList) {
            JsonTreeData treeData = new JsonTreeData();
            treeData.setId(perm.getPermissionId().toString());
            treeData.setPid(perm.getParentId().toString());
            treeData.setText(perm.getName().toString());
            Attributes attributes=new Attributes();
            attributes.setUrl(perm.getUrl());
            attributes.setIcon(perm.getIcon());
            treeData.setAttributes(attributes);
            treeDataList.add(treeData);
        }
        List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
        return newTreeDataList;
    }

    @Override
    public List<Permission> findPermissionList() {
        return permissionMapper.findlist();
    }

    @Override
    public List<Permission> selectPerssionByroleId(Long roleId) {
        return permissionMapper.selectPerssionByroleId(roleId);
    }

}
