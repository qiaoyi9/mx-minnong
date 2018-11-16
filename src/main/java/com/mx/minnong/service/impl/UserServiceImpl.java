package com.mx.minnong.service.impl;

import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.UserMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.User;
import com.mx.minnong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 18:37  2018/11/16
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean createUser(User user) {
        if (null != user){
            return userMapper.createUser(user);
        }else {
            log.info("【用户创建】 "+NetEnum.CREATEUSER_PARAM_ISEMPTY.getMsg());
            throw new NetException(NetEnum.CREATEUSER_PARAM_ISEMPTY);
        }
    }

    @Override
    public User findOnById(String id) {
        if (StringUtils.isEmpty(id)){
            log.info("【查询用户】 " + NetEnum.USER_IDPARAM_ISEMPTY.getMsg());
            throw new NetException(NetEnum.USER_IDPARAM_ISEMPTY);
        }else {
            return userMapper.findOnById(id);
        }
    }
}
