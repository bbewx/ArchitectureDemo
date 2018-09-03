package com.code.controller;

import com.code.model.UserDomain;
import com.code.service.UserService;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018\5\1 0001.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserDomain user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        return userService.findAllUser(pageNum,pageSize);
    }

    /**********************以下方法用来测试Redis缓存*******************************/
    @GetMapping("/users")
    @ResponseBody
    public List<UserDomain> users() {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDomain findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/user/{id}/{name}")
    @ResponseBody
    public Map update(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        UserDomain user = userService.findUserById(id);
        user.setUserName(name);
        userService.update(user);
        return ImmutableMap.of("ret", 0, "msg", "ok");
    }

    @GetMapping("/upuser/{id}")
    @ResponseBody
    public UserDomain upuser(@PathVariable("id") Integer id) {
        return userService.upuser(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public UserDomain remove(@PathVariable("id") Integer id) {
        return userService.remove(id);
    }
}
