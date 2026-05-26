package com.liyu.Controller;

import com.liyu.Pojo.LoginInfo;
import com.liyu.Pojo.Result;
import com.liyu.Pojo.User;
import com.liyu.Service.Impl.UserServiceImpl;
import com.liyu.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    private UserService userService;

    // 注册
    @PostMapping("/register")
    public Result CreateUser(@RequestBody User user)
    {
        log.info("创建用户");
        userService.CreateUser(user);
        return Result.success();
    }

    // 登录
    @PostMapping("/login")
    public Result Login(@RequestBody User user)
    {
        log.info("用户登录");
        LoginInfo info = userService.Login(user);
        return info == null ? Result.error("用户名或密码错误") : Result.success(info);
    }

}
