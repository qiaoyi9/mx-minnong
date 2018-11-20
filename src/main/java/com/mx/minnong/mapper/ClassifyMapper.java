package com.mx.minnong.mapper;

import com.mx.minnong.pojo.Classify;
import com.mx.minnong.utils.MyMapper;

import java.util.List;

public interface ClassifyMapper extends MyMapper<Classify> {

    List<Classify> findAllByFid(Integer fId);
}