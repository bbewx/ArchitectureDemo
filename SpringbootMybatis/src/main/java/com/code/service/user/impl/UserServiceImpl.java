package com.code.service.user.impl;

import com.code.dao.UserDao;
import com.code.model.UserDomain;
import com.code.service.user.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018\5\1 0001.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    @Override
    public int addUser(UserDomain user) {

        return userDao.insert(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<UserDomain> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userDao.selectUsers();
    }

    /**********************以下方法用来测试Redis缓存*******************************/
    private Map<Integer, UserDomain> userMap = new HashMap<>();

    public UserServiceImpl() {
        UserDomain u1=new UserDomain();
        u1.setUserId(1);
        u1.setUserName("1111");
        u1.setPassword("11223434");
        UserDomain u2=new UserDomain();
        u2.setUserId(2);
        u2.setUserName("1111");
        u2.setPassword("11223434");
        UserDomain u3=new UserDomain();
        u3.setUserId(3);
        u3.setUserName("1111");
        u3.setPassword("11223434");

        userMap.put(1,u1);
        userMap.put(2,u2);
        userMap.put(3,u3);
    }

    @Override
    public List list() {
        return Arrays.asList(userMap.values().toArray());
    }

    @Override
    @Cacheable(value = "user", key = "'user'.concat(#id.toString())")
    public UserDomain findUserById(Integer id) {
        //log.info("findUserById query from db, id: {}", id);
        System.out.println("findUserById query from db, id: {}======"+id);
        return userMap.get(id);
    }

    @Override
    @CachePut(value = "user", key = "'user'.concat(#user.id.toString())")
    public void update(UserDomain user) {
        //log.info("update db, user: {}", user.toString());
        System.out.println("findUserById query from db, id: {}======");
        userMap.put(user.getUserId(), user);
    }

    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public UserDomain remove(Integer id) {
        //log.info("remove from db, id: {}", id);
        System.out.println("findUserById query from db, id: {}======");
        UserDomain user = userMap.get(id);
        userMap.remove(id);
        return user;
    }

    @Override
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public UserDomain upuser(Integer id) {
        UserDomain d= userMap.get(id);
        d.setUserName("000000000000000000000000000000000000000000000000");
        return d;
    }
    /**************************************************************************/
}
