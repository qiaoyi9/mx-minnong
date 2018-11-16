package com.mx.minnong.service;

import com.mx.minnong.pojo.User;

/**
 * @Author: 乔一
 * @createtime 2018-11-16 18:36
 **/
public interface UserService {

    /*创建用户*/
    boolean createUser(User user);

    /*根据id查询用户*/
    User findOnById(String id);
}
