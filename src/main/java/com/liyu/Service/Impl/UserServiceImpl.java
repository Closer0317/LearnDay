package com.liyu.Service.Impl;

import com.liyu.Mapper.UserMapper;
import com.liyu.Pojo.LoginInfo;
import com.liyu.Pojo.User;
import com.liyu.Service.UserService;
import com.liyu.Utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void CreateUser(User user) {
        userMapper.CreateUser(user);
    }

    @Override
    public LoginInfo Login(User user) {
        LoginInfo u = userMapper.Login(user);
        //生成jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", u.getId());
        claims.put("username", u.getUsername());
        String jwt = JwtUtils.generateToken(claims);
        log.info("生成jwt: {}", jwt);
        return new LoginInfo(u.getId(), u.getUsername(), u.getAvatar(),jwt);
    }

    @Override
    public List<User> SearchUser(String name) {
        return userMapper.SearchUser(name);
    }
}