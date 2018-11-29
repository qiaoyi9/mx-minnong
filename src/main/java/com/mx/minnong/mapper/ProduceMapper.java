package com.mx.minnong.mapper;

import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.vo.ProduceVO;
import com.mx.minnong.utils.MyMapper;

import java.util.List;

public interface ProduceMapper extends MyMapper<Produce> {
    //获得所有推荐产品
    List<Produce> findAllRecommend(Integer pro_recommend);

    //根据大类小类种类和省份市区价格条件获得产品  pro_lowest最低价格 pro_highest最高价格
    List<Produce> findAllByCondition(ProduceVO produceVO);

    //根据产品Id 获得产品
    Produce findById(Integer proId);

    //根据proBrowse获得前多少热门产品
    List<Produce>  findHot(Integer topNum);
}