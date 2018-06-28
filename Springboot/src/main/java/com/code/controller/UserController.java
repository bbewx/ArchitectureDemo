package com.code.controller;

import com.code.domain.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建用户控制器。
 * "@RestController"
 */
@RestController
@EnableAutoConfiguration
public class UserController {

    @RequestMapping("/login")
    public User login(){
        User user= new User();
        user.setId(123);
        user.setUsername("qwe");
        user.setPassword("456");
        return user;
    }

    @RequestMapping("/print")
    public String print1(){
        return "HELLO WORLD";
    }
}
