package com.liyu.Service;

import com.liyu.Pojo.LoginInfo;
import com.liyu.Pojo.User;

import java.util.List;


public interface UserService {

    List<User> SearchUser(String name);

    void CreateUser(User user);

    LoginInfo Login(User user);
}
