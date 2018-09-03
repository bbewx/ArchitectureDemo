package com.code.service;

import com.code.model.UserDomain;

import java.util.List;

/**
 * Created by Administrator on 2018\5\1 0001.
 */
public interface UserService {

    /**********************以下方法用来测试Mybatis集成*****************************/
    int addUser(UserDomain user);

    List<UserDomain> findAllUser(int pageNum, int pageSize);
    /**************************************************************************/

    /**********************以下方法用来测试Redis缓存*******************************/
    List<UserDomain> list();

    UserDomain findUserById(Integer id);

    void update(UserDomain user);

    UserDomain remove(Integer id);

    UserDomain upuser(Integer id);
    /**************************************************************************/
}
