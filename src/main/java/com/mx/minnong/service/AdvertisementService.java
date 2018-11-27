package com.mx.minnong.service;

import com.mx.minnong.pojo.Advertisement;

import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/27 10:42
 */
public interface AdvertisementService {
    //根据状态获取广告(需判断是否已经过期) 无条件时获得全部
    List<Advertisement> findByState(Integer adverState);

}
