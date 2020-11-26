package com.index.controller;

import com.index.common.Result;
import com.index.pojo.User;
import com.index.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author index
 * @date 2020/11/12
 **/
@RequestMapping("/xjgl/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result forelogin(@RequestParam("no") String no,
                            @RequestParam("password") String password,
                            HttpSession session){
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(no, password);
        SecurityUtils.getSubject().getSession().setTimeout(1800000);  //30分钟未发送任何请求则session过期

        try {
            subject.login(token);
            User user = userService.getByNo(no);
            session.setAttribute("user", user);
        } catch (AuthenticationException e){
            return Result.fail("账号或密码错误");
        }

        return Result.success();
    }
}
