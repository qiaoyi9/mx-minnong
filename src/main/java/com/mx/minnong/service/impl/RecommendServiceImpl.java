package com.mx.minnong.service.impl;

import com.github.pagehelper.PageHelper;
import com.mx.minnong.mapper.ProduceMapper;
import com.mx.minnong.mapper.RecommendMapper;
import com.mx.minnong.pojo.Recommend;
import com.mx.minnong.pojo.qo.PageQO;
import com.mx.minnong.service.RecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ProduceMapper produceMapper;


    //获得所有推荐产品
    @Override
    @Transactional
    public List<Recommend> finAllByProduce(PageQO pageQO) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageQO.getPageNum(), pageQO.getPageSize());
        List<Recommend> list=recommendMapper.finAllByProduce();
        Recommend recommend;
        //迭代器 用于删除多个元素 (remove( index) 会漏元素 删除特定，foreach删除多个会报 ConcurrentModificationException 适于删除单个后结束循环 )
        Iterator<Recommend> it = list.iterator();
        while(it.hasNext()){
            recommend=it.next();
            if(!recommend.getRenEndtime().after(new Date())){
                recommendMapper.delete(recommend); //推荐过期 删除
                it.remove();
            }
        }
        List<Recommend> recommends = new ArrayList<>();
        if (list.size() > 0) {
            for (Recommend r : list) {
                r.setProduce(produceMapper.findById(r.getRecId()));
                recommends.add(r);
            }
        }

        return recommends;
    }

}
