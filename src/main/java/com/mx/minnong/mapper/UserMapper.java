package com.mx.minnong.mapper;

import com.mx.minnong.pojo.User;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 18:22  2018/11/16
 */

public interface UserMapper {

    boolean createUser(User user);

    User findOnById(String id);
}
