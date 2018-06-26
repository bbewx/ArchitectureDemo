package com.code.controller;

import com.code.domain.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018\6\26 0026.
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
