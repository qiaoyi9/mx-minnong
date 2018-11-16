package com.mx.minnong.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 18:17  2018/11/16
 * @Description: 用户类
 */
@Data
public class User {

    private String id;

    private String username;

    private String password;

    private String phone;

    private String lastIp;

    private Date createTime;

    private Date lastLoginTime;
}
