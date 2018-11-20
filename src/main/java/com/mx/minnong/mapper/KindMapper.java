package com.mx.minnong.mapper;

import com.mx.minnong.pojo.Kind;
import com.mx.minnong.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KindMapper extends MyMapper<Kind> {
    //根据Classfiy id 查询子类
    List<Kind> findAllByKindFid(Integer kindFid);
}