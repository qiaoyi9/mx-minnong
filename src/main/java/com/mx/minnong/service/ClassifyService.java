package com.mx.minnong.service;

import com.mx.minnong.pojo.Classify;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:07  2018/11/20
 * @Description:
 */

public interface ClassifyService {

    //根据bigclass id 查询所有
    List<Classify> findAllByFid(Integer fId);

    List<Classify> findAll();
}
