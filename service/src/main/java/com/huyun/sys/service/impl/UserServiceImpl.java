package com.huyun.sys.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyun.sys.dao.UserMapper;
import com.huyun.sys.dao.UserRoleMapper;
import com.huyun.sys.model.User;
import com.huyun.sys.model.UserRole;
import com.huyun.sys.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public User queryObject(String account) {
        User map=new User();
        map.setUsername(account);
        return userMapper.queryObject(account);
    }

    @Override
    public int insert() {
        User map=new User();
        map.setUsername("test");
        userMapper.insert(map);
        return map.getUserId();
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteByPrimaryKey(String[] id) {
        for(String  userId: id){
            User user=userMapper.selectByPrimaryKey(Integer.parseInt(userId));
            if(user.getUsername().equals("admin")) {
                return 0;
            }
            userMapper.deleteByPrimaryKey(Integer.parseInt(userId));
        }
        return 1;
    }

    @Override
    public PageInfo<User> selectByPage(Integer page, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(page, pageSize);
        Condition condition=new Condition(User.class);
        if(map!=null){
            if(map.get("key")!=null &&map.get("key")!=""){
                condition.createCriteria().andCondition("username like '%"+map.get("key").toString()+"%'");
            }
        }
        condition.setOrderByClause("create_time desc");
        List<User> list =  userMapper.selectByExample(condition);
        return new PageInfo<>(list);
    }


    @Override
    public List<User> selectByT(User user) {
        return null;
    }

    @Override
    public User findOne(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public Map<String, Object> addRoleUser(Integer userId, String ids) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        int count = 0;
        try {
            //先删除原有的。
            userRoleMapper.deleteByUserId(userId);
            if(StringUtils.isNotBlank(ids)){
                String[] idArray = null;
                if(StringUtils.contains(ids,",")){
                    idArray = ids.split(",");
                }else{
                    idArray = new String[]{ids};
                }
                //添加新的。
                for (String rid : idArray) {
                    //这里严谨点可以判断，也可以不判断。这个{@link StringUtils 我是重写了的}
                    if(StringUtils.isNotBlank(rid)){
                        UserRole entity = new UserRole();
                        entity.setRoleId(Integer.parseInt(rid));
                        entity.setUserId(userId);
                        count += userRoleMapper.insertSelective(entity);
                    }
                }
            }
            resultMap.put("status", 200);
            resultMap.put("message", "操作成功");
        } catch (Exception e) {
            resultMap.put("status", 200);
            resultMap.put("message", "操作失败，请重试！");
        }
        return resultMap;
    }

    @Override
    public User findByAccountAndPwd(String account, String pwd) {
        User user  = new User();
        user.setUsername(account);
        user.setPassword(pwd);
        return userMapper.selectOne(user);
    }
}
