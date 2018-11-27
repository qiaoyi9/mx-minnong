package com.mx.minnong.mapper;

import com.mx.minnong.pojo.Advertisement;
import com.mx.minnong.utils.MyMapper;

import java.util.List;

public interface AdvertisementMapper extends MyMapper<Advertisement> {
    //根据状态获取广告(需判断是否已经过期) 无条件时获得全部
    List<Advertisement> findByState(Integer adverState);
}