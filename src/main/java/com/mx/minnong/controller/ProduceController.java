package com.mx.minnong.controller;

import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.vo.ProduceVO;
import com.mx.minnong.service.ProduceService;
import com.mx.minnong.utils.BaseClassRedisKey;
import com.mx.minnong.utils.JoeJSONResult;
import com.mx.minnong.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/23 11:59
 */

@RestController
@RequestMapping("/produce/")
@Slf4j
public class ProduceController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ProduceService produceService;

    /*
     * 根据大类小类种类和省份市区价格条件获得产品  pro_lowest最低价格 pro_highest最高价格
     */
    @RequestMapping("findAllByCondition")
    public JoeJSONResult findAllByCondition(ProduceVO produceVO) throws IllegalAccessException {
        boolean flag = false;
        Class produceVOClass = produceVO.getClass();
        //produceVOClass = produceVOClass.getSuperclass() 得到父类的class文件
        for (; produceVOClass != Object.class; produceVOClass = produceVOClass.getSuperclass()) {//向上循环  遍历父类
            Field[] field = produceVOClass.getDeclaredFields();
            for (Field f : field) {
                f.setAccessible(true);
                if (f.get(produceVO) != null) {
                    flag = true;
                    break;
                } // System.out.println("属性："+f.getName()+" 值："+f.get(produceVO));
            }
        }
        if (flag) {
            if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_FINDALLBYCONDITIONNull)) {
                List<Produce> Produces = redisUtil.range(BaseClassRedisKey.BASECLASS_FINDALLBYCONDITIONNull);
                return JoeJSONResult.ok(Produces);
            } else {
                log.info("【Get Redis Data】 findAllByCondition is null ");
                List<Produce> Produces = produceService.findAllByCondition(produceVO);
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_FINDALLBYCONDITIONNull, Produces);
                //保存3天
                redisUtil.pireKey(BaseClassRedisKey.BASECLASS_FINDALLBYCONDITIONNull, 3, TimeUnit.DAYS);
                return JoeJSONResult.ok(Produces);
            }
        } else {
            List<Produce> Produces = produceService.findAllByCondition(produceVO);
            return JoeJSONResult.ok(Produces);
        }
    }


    //获得产品中推荐产品
   /* @RequestMapping("findAllRecommend/{pro_recommend}")
    public JoeJSONResult findAllRecommend(@PathVariable Integer pro_recommend){
        //避免redis key重复  将此id作为盐值拼接key
        if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_FINDALLRECOMMEND+pro_recommend)){
            List<Produce>  produces= redisUtil.range(BaseClassRedisKey.BASECLASS_FINDALLRECOMMEND+pro_recommend);
            return JoeJSONResult.ok(produces);
        }else {
            log.info("【Get Redis Data】 findAllRecommend is null pro_recommend={}",pro_recommend);
            List<Produce>  produceList = produceService.findAllRecommend(pro_recommend);
            if (!produceList.isEmpty()){
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_FINDALLRECOMMEND+pro_recommend,produceList);
                //3天
                redisUtil.pireKey(BaseClassRedisKey.BASECLASS_FINDALLRECOMMEND+pro_recommend,3, TimeUnit.DAYS);
            }
            return JoeJSONResult.ok(produceList);
        }
    }*/
}
