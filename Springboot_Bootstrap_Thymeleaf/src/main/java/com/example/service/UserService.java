package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;

import java.util.List;

/**
 * @Author:abc
 * @Description:
 * @params:$params$
 * @return: $returns$
 * @Date: $date$ $time$
 */

public interface UserService {

    public boolean add(UserDto userDto);

    public boolean del(String userId);

    public List<User> findAll();

    public UserDto sel(String userId);

//    public List<User> fuzzyQuery(UserDto userDto);
}
