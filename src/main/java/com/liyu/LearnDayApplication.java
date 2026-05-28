package com.liyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.liyu.Mapper")
@SpringBootApplication
public class LearnDayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnDayApplication.class, args);
    }

}
