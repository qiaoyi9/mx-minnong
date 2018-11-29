package com.mx.minnong.service;

import com.mx.minnong.pojo.Proimg;

import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/29 15:59
 */
public interface ProimgService {
    //根据商品Id获得图片
    List<Proimg> findByProimgPro(Integer proimgPro);
}
