package com.mx.minnong.mapper;

import com.mx.minnong.pojo.Recommend;
import com.mx.minnong.utils.MyMapper;

import java.util.List;

public interface RecommendMapper extends MyMapper<Recommend> {

    List<Recommend> finAllByProduce();
}