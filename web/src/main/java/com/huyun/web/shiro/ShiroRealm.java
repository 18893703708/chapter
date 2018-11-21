package com.huyun.web.shiro;



import com.huyun.sys.dao.PermissionMapper;
import com.huyun.sys.dao.RoleMapper;
import com.huyun.sys.dao.UserMapper;
import com.huyun.sys.model.Permission;
import com.huyun.sys.model.Role;
import com.huyun.sys.model.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 认证
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RoleMapper roleMapper;


    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User shiroUser = (User) principals.getPrimaryPrincipal();
        //角色

        List<Role> roleList= roleMapper.selectByUserId(shiroUser.getUserId());
        Set<String> roleSet = new HashSet<String>();
        for (Role roleId : roleList) {
            roleSet.add(roleId.getType());
        }
        //权限
        List<Permission> permissionList = new ArrayList<Permission>();
        if(roleSet.contains("888888"))//超级管理员
        {
            //获取所有权限
            permissionList= permissionMapper.selectAll();
        }else
        {
            //获取用户所有权限
            permissionList= permissionMapper.selectByUserId(shiroUser.getUserId());
        }
        Set<String> permissionSet = new HashSet<String>();
        for (Permission res : permissionList) {

            if(StringUtils.isNotEmpty(res.getPerms()))
            {
                permissionSet.add(res.getPerms());
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleSet);
        info.addStringPermissions(permissionSet);

        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User map = new User();
        map.setUsername( username);
        String password = new String((char[]) token.getCredentials());
        // 查询用户信息
        User user = userMapper.selectOne(map);
        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        // 密码错误
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());


        return info;
    }
}
