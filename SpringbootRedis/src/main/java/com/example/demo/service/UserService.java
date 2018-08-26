package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;

/**
 * 用户服务接口。
 */
public interface UserService {

    List<User> list();

    User findUserById(Integer id);

    void update(User user);

    User remove(Integer id);

    User upuser(Integer id);
}
