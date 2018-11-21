package com.huyun.sys.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyun.sys.dao.RoleMapper;
import com.huyun.sys.dao.RolePermissionMapper;
import com.huyun.sys.model.Role;
import com.huyun.sys.model.RolePermission;
import com.huyun.sys.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    protected RoleMapper roleMapper;
    @Autowired
    protected RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public Role findByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateByPrimaryKey(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Role> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(page,pageSize);
        Condition condition=new Condition(Role.class);
        if(map!=null){
            if(map.get("key")!=null &&map.get("key")!=""){
                condition.createCriteria().andCondition("role_name like '%"+map.get("key").toString()+"%'");
            }
        }
        condition.setOrderByClause("create_time desc");
        List<Role> list=roleMapper.selectByExample(condition);
        return new PageInfo<>(list);
    }

    @Override
    public List<Role> selectByT(Role role) {
        return roleMapper.select(role);
    }

    @Override
    public Role findOne(Role role) {
        return null;
    }

    @Override
    public List<Role> selectByUserId(Integer userId) {
        return roleMapper.selectByUserId(userId);
    }

    @Override
    public List<Role> selectBylikename(Role role) {
        return roleMapper.selectBylikename(role);
    }

    @Override
    public int deleteRole(Integer roleId) {
        return roleMapper.deleteRole(roleId);
    }

    @Override
    public Map<String, Object> addPermission2Role(Long roleId, String ids) {
        rolePermissionMapper.deleteByRid(roleId);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(StringUtils.isNotBlank(ids)){
                String[] idArray = null;
                if(StringUtils.contains(ids, ",")){
                    idArray = ids.split(",");
                }else{
                    idArray = new String[]{ids};
                }
                for (String pid : idArray) {

                    if(StringUtils.isNotBlank(pid)){
                       /* RolePermission entity = new RolePermission();
                        entity.setRid(roleId);
                        entity.setPid(new Long(pid));*/
                       RolePermission entity=new RolePermission();
                       entity.setRoleId(roleId);
                       entity.setPermissionId(new Long(pid));
                        rolePermissionMapper.insertSelective(entity);
                    }
                }
            }
            resultMap.put("status", 200);
            resultMap.put("message", "操作成功");
        } catch (Exception e) {
            resultMap.put("status", 404);
            resultMap.put("message", "操作失败，请重试！");
        }

        return resultMap;

    }

}
