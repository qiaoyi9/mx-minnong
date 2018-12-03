package com.mx.minnong.mapper;


import com.mx.minnong.pojo.Seller;
import com.mx.minnong.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface SellerMapper extends MyMapper<Seller> {
    //根据id获得卖家
    @Select("select * from seller where sel_id=#{selId}")
    Seller findById(Integer selId);
}