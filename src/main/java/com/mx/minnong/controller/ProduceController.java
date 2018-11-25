package com.mx.minnong.controller;

import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.vo.ProduceVO;
import com.mx.minnong.service.ProduceService;
import com.mx.minnong.utils.BaseClassRedisKey;
import com.mx.minnong.utils.JoeJSONResult;
import com.mx.minnong.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/23 11:59
 */

@Controller
@RequestMapping("/Produce/")
@Slf4j
public class ProduceController {

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private ProduceService produceService;

    @RequestMapping("findAllByCondition")
    @ResponseBody
    public JoeJSONResult findAllByCondition(ProduceVO produceVO) throws IllegalAccessException {
        boolean flag=false;
        System.out.println("produceVO " +produceVO);
        Class produceVOClass = produceVO.getClass();
        for (; produceVOClass != Object.class; produceVOClass = produceVOClass.getSuperclass()) {//向上循环  遍历父类
            Field[] field = produceVOClass.getDeclaredFields();
            for (Field f : field) {
                f.setAccessible(true);
                if(f.get(produceVO)!=null){
                    flag=true;
                    break;
                }
               // System.out.println("属性："+f.getName()+" 值："+f.get(produceVO));

            }
        }
        if(flag){
            if(redisUtil.existsKey(BaseClassRedisKey.BASECLASS_FINDALLBYCONDITIONNull)){
                List<Produce> Produces=redisUtil.range(BaseClassRedisKey.BASECLASS_FINDALLBYCONDITIONNull);
                return JoeJSONResult.ok(Produces);
            }else{
                log.info("【Get Redis Data】 findAllByCondition is null ");
                List<Produce> Produces=produceService.findAllByCondition(null);
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_FINDALLBYCONDITIONNull,Produces);
                return JoeJSONResult.ok(Produces);
            }
        }else{
            List<Produce> Produces=produceService.findAllByCondition(produceVO);
            return JoeJSONResult.ok(Produces);
        }
    }
}
