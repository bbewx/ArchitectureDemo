package com.code.dao;

import com.code.model.UserDomain;

import java.util.List;

/**
 * Created by Administrator on 2018\5\1 0001.
 */
public interface UserDao {

    int insert(UserDomain record);

    List<UserDomain> selectUsers();

}
