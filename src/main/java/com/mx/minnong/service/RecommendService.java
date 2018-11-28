package com.mx.minnong.service;

import com.mx.minnong.pojo.Recommend;
import com.mx.minnong.pojo.vo.PageVo;

import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/26 11:26
 */
public interface RecommendService {
    //获得所有推荐产品
    List<Recommend> findAll(PageVo pageVo);

}
