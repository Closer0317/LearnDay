package com.liyu.Controller;

import com.liyu.Pojo.Result;
import com.liyu.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private UserService userService;
    @GetMapping("/username")
    public Result SearchUser(String name){
        return Result.success(userService.SearchUser(name));
    }
}
