package com.index.shiro;


import com.index.pojo.User;
import com.index.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


/**
 * @author index
 * @date 2020/8/18
 **/

public class UserRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = (String) getAvailablePrincipal(principalCollection);

        User user = userService.getByNo(username);
        //获取角色Id
        int roleId = user.getRoleId();
        Set<String> r = new HashSet<>();
        r.add(String.valueOf(user.getRoleId()));
        info.setRoles(r);

//        info.addStringPermission("user:add");

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");



        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;

        //用户名，密码 从数据库中取
        User user = userService.getByNo(userToken.getUsername());



        if(user == null)
            return null; //抛出异常 UnknownAccountException


//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
//                user.getName(),
//                user.getPassword(),
//                ByteSource.Util.bytes(user.getName()),
//                getName()
//        );
//
//        return  simpleAuthenticationInfo;

//        //密码认证，shiro做
//        return new SimpleAuthenticationInfo("", user.getPassword(),
//                ByteSource.Util.bytes(user.getSalt()), getName());

        //密码认证，shiro做
        return new SimpleAuthenticationInfo("", user.getPassword(),
                getName());

    }
}
