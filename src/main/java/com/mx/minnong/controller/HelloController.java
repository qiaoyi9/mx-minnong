package com.mx.minnong.controller;

import com.mx.minnong.utils.IpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 21:36  2018/11/16
 * @Description:
 */
@RestController
public class HelloController {



    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return IpUtil.getIpAddr(request);
    }
}
