package com.example.zsmes.realm;

import com.example.zsmes.entity.SysUser;
import com.example.zsmes.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /*
     * 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录的用户信息
        Subject subject= SecurityUtils.getSubject();
        SysUser sysUser=(SysUser) subject.getPrincipal();
        //设置角色
        Set<String> roles=new HashSet<>();
        roles.add(sysUser.getRole());
        System.out.println(sysUser.getPerms());
        System.out.println(sysUser.getRole());
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);

        //设置权限
        info.addStringPermission(sysUser.getPerms());
        return info;
    }


    /*
     * 认证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //判断用户名
        SysUser sysUser = sysUserService.findByUsername(token.getUsername());
        if (sysUser != null) {
            //判断密码
            System.out.println("-------------------------------------");
            return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), getName());
        }
        return null;
    }
}
