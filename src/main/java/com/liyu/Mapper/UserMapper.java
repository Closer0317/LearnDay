package com.liyu.Mapper;

import com.liyu.Pojo.LoginInfo;
import com.liyu.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void CreateUser(User user);

    List<User> SearchUser(String name);

    LoginInfo Login(User user);
}
