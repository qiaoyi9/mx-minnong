package com.mx.minnong.controller;

import com.mx.minnong.pojo.Advertisement;
import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.vo.AdvertisementVo;
import com.mx.minnong.service.AdvertisementService;
import com.mx.minnong.service.ProduceService;
import com.mx.minnong.utils.BaseClassRedisKey;
import com.mx.minnong.utils.JoeJSONResult;
import com.mx.minnong.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/27 20:18
 */

@Slf4j
@RestController
@RequestMapping("/advertisement/")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private ProduceService produceService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 根据状态获取广告无条件时获得全部
     *
     */

    @RequestMapping("findByState")
    public JoeJSONResult findByState(@RequestParam(value = "adverState",required=false) Integer adverState){
        Produce produce;
        AdvertisementVo advertisementVo=new AdvertisementVo();
        List<AdvertisementVo> advertisementVos=new ArrayList<>();
        List<Advertisement> list= advertisementService.findByState(adverState);
        for (Advertisement advertisement:list
        ) {
            produce=produceService.findById(advertisement.getAdverProid());
            advertisementVo.setAdverId(advertisement.getAdverId());
            advertisementVo.setAdverPosition(advertisement.getAdverPosition());
            advertisementVo.setAdverProid(advertisement.getAdverProid());
            advertisementVo.setProduce(produce);
            advertisementVos.add(advertisementVo);
        }
        return JoeJSONResult.ok(advertisementVos);
    }
}
