package com.liyu.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer role;
    private String avatar = "/images/1.jpg";
    private String phone;
    private String gender;
    private LocalDateTime createTime;

}
