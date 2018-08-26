package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户控制层。
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> users() {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/user/{id}/{name}")
    @ResponseBody
    public Map update(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = userService.findUserById(id);
        user.setUserName(name);
        userService.update(user);
        return ImmutableMap.of("ret", 0, "msg", "ok");
    }

    @GetMapping("/upuser/{id}")
    @ResponseBody
    public User upuser(@PathVariable("id") Integer id) {
        return userService.upuser(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public User remove(@PathVariable("id") Integer id) {
        return userService.remove(id);
    }
}
