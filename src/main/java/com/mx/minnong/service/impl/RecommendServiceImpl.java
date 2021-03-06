package com.mx.minnong.service.impl;

import com.mx.minnong.mapper.ProduceMapper;
import com.mx.minnong.mapper.RecommendMapper;
import com.mx.minnong.pojo.Recommend;
import com.mx.minnong.service.RecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/26 11:26
 */
@Slf4j
@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendMapper recommendMapper;


    //获得所有推荐产品
    @Override
    public List<Recommend> findAll() {
        List<Recommend> list=new ArrayList<>();
        list=recommendMapper.selectAll();
        Recommend recommend;
        //迭代器 用于删除多个元素 (remove( index) 会漏元素 删除特定，foreach删除多个会报 ConcurrentModificationException 适于删除单个后结束循环 )
        Iterator<Recommend> it = list.iterator();
        while(it.hasNext()){
            recommend=it.next();
            System.out.println(recommend);
            if(!recommend.getRenEndtime().after(new Date())){
                recommendMapper.delete(recommend); //推荐过期 删除
                it.remove();
            }
        }
        return list;
    }

}
