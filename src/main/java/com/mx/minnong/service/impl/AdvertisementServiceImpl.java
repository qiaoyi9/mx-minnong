package com.mx.minnong.service.impl;

import com.mx.minnong.mapper.AdvertisementMapper;
import com.mx.minnong.mapper.ProduceMapper;
import com.mx.minnong.pojo.Advertisement;
import com.mx.minnong.pojo.Produce;
import com.mx.minnong.service.AdvertisementService;
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
 * @Date: Createdtime 2018/11/27 10:43
 */
@Slf4j
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementMapper advertisementMapper;

    @Autowired
    private ProduceMapper produceMapper;

    /**
     * 获得广告
     * @param adverState
     * @return
     */

    @Transactional
    @Override
    public List<Advertisement> findByState(Integer adverState) {
        Advertisement advertisement=null;
        Produce produce;
        List<Advertisement> result=new ArrayList<>();
        List<Advertisement> advertisements= advertisementMapper.findByState(adverState);
        System.out.println(advertisements.size());
        if( adverState!=null  && adverState==1 ){
            Iterator<Advertisement> iterator=advertisements.iterator();
            while(iterator.hasNext()){
                advertisement=iterator.next();
                if(advertisement.getAdverEndtime().before(new Date())){
                    advertisement.setAdverState(2);
                    advertisementMapper.updateByPrimaryKey(advertisement);  //过期修改状态
                    iterator.remove();
                }
            }
            for (Advertisement advertisement1 : advertisements
            ) {
                produce=produceMapper.findById(advertisement1.getAdverProid());
                advertisement1.setProduce(produce);
                result.add(advertisement1);
            }
        }
        return result;
    }
}