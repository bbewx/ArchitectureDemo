package com.example.demo.service.impl;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务接口实现类。
 * 本类只是演示Redis的使用，不和数据库打交道。
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private Map<Integer, User> userMap = new HashMap<>();

    /**
     * 构造函数。目的是初始化用户数据。
     */
    public UserServiceImpl() {
        User u1=new User();
        u1.setUserId(1);
        u1.setUserName("zhangsan");
        u1.setPassword("11223434");
        User u2=new User();
        u2.setUserId(2);
        u2.setUserName("lisi");
        u2.setPassword("11223434");
        User u3=new User();
        u3.setUserId(3);
        u3.setUserName("wangwu");
        u3.setPassword("11223434");

        userMap.put(1,u1);
        userMap.put(2,u2);
        userMap.put(3,u3);
    }

    @Override
    public List list() {
        return Arrays.asList(userMap.values().toArray());
    }

    /**
     * 第一次查询id对应的用户数据时，会查库（因此会打印信息）；第二次查询id对应的用户数据时，
     * 直接从缓存中查，不会查库。
     */
    @Override
    @Cacheable(value = "user", key = "'user'.concat(#id.toString())")
    public User findUserById(Integer id) {
        System.out.println("findUserById query from db, id: {}======"+id);
        return userMap.get(id);
    }

    /**
     * "@CachePut"注解要求调用方法时每次都执行方法体内部逻辑。
     * 注意：必须有返回值，否则不会保存至Redis缓存。
     */
    @Override
    @CachePut(value = "user", key = "'user'.concat(#user.getUserId().toString())")
    public User update(User user) {
        System.out.println("update query from db, id: {}======" + user.getUserId());
        userMap.put(user.getUserId(), user);
        return user;
    }

    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public User remove(Integer id) {
        System.out.println("findUserById query from db, id: {}======");
        User user = userMap.get(id);
        userMap.remove(id);
        return user;
    }

    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public User upuser(Integer id) {
        User d= userMap.get(id);
        d.setUserName("000000000000000000000000000000000000000000000000");
        return d;
    }
}
