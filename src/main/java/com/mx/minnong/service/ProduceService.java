package com.mx.minnong.service;

/*
 * 产品业务类
 */

import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.qo.PageQO;
import com.mx.minnong.pojo.qo.ProduceQO;

import java.util.List;

public interface ProduceService {
    //获得所有推荐产品
    List<Produce> findAllRecommend(Integer pro_recommend);

    //根据大类小类和省份市区价格条件获得产品  pro_lowest最低价格 pro_highest最高价格
    List<Produce> findAllByCondition(ProduceQO produceQO);

    //根据产品Id 获得产品
    Produce findById(Integer proId);

    //获得热门产品
    List<Produce> findHot(PageQO pageQO);

    //根据卖家ID获得商品
    List<Produce> findByProseller(PageQO pageQO, Integer proSeller);

}
