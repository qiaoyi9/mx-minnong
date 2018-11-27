package com.mx.minnong.controller;

import com.mx.minnong.pojo.Advertisement;
import com.mx.minnong.service.AdvertisementService;
import com.mx.minnong.utils.BaseClassRedisKey;
import com.mx.minnong.utils.JoeJSONResult;
import com.mx.minnong.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private RedisUtil redisUtil;

    /*
        根据状态获取广告无条件时获得全部
     */
    @RequestMapping("findByState")
    public JoeJSONResult findByState(@RequestParam("adverState") Integer adverState){
        //ADVERTISEMENT_FINDALLBYCONDITION
        List<Advertisement>  Advertisements=advertisementService.findByState(adverState);
        for (Advertisement advertisement:Advertisements) {
            if(redisUtil.existsKey(BaseClassRedisKey.ADVERTISEMENT_FINDALLBYCONDITION+advertisement.getAdverProid())){

            }
        }
        return null;
    }
}
