package com.example.base;

import com.example.dto.UserDto;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;


/**
 * @Author:abc
 * @Description:
 * @params:$params$
 * @return: $returns$
 * @Date: $date$ $time$
 */

public interface UserRepository extends JpaRepository<User,String> ,Serializable {

//    @Query(value = "")
//    List<User> fuzzyQuery(UserDto userDto);
}
