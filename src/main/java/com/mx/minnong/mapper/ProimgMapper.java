package com.mx.minnong.mapper;

import com.mx.minnong.pojo.Proimg;
import com.mx.minnong.utils.MyMapper;

import java.util.List;

public interface ProimgMapper extends MyMapper<Proimg> {
    //根据商品Id获得图片
    List<Proimg> findByProimgPro(Integer proimgPro);
}