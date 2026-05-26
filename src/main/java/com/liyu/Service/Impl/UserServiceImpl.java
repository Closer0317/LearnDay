package com.liyu.Service.Impl;

import com.liyu.Mapper.UserMapper;
import com.liyu.Pojo.LoginInfo;
import com.liyu.Pojo.User;
import com.liyu.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return u;
    }

    @Override
    public List<User> SearchUser(String name) {
        return userMapper.SearchUser(name);
    }
}