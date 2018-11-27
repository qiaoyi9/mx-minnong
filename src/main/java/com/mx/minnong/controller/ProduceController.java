package com.mx.minnong.controller;

import com.github.pagehelper.PageInfo;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
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
    @RequestMapping(value ="findAllByCondition")
    public JoeJSONResult findAllByCondition(ProduceVO produceVO) throws IllegalAccessException{
        List<Produce> produces=new ArrayList<Produce>();
        boolean flag = false;
        Class produceVOClass = produceVO.getClass();
        //produceVOClass = produceVOClass.getSuperclass() 得到父类的class文件
            Field[] field = produceVOClass.getDeclaredFields();
            for (Field f : field) {
                f.setAccessible(true);
                if (f.get(produceVO) != null && !(f.getName().equals("pageNum") || f.getName().equals("pageSize"))) {
                    flag = true;
                    break;
                } // System.out.println("属性："+f.getName()+" 值："+f.get(produceVO));
            }
        if (!flag) {
            if (redisUtil.existsKey(BaseClassRedisKey.PRODUCECLASS_FINDALLBYCONDITIONNULL+produceVO.getPageNum()+"_"+produceVO.getPageSize())) {
                produces = redisUtil.range(BaseClassRedisKey.PRODUCECLASS_FINDALLBYCONDITIONNULL+produceVO.getPageNum()+"_"+produceVO.getPageSize());
                PageInfo pageInfo = new PageInfo(produces);
            } else {
                log.info("【Get Redis Data】 findAllByCondition is null ");
                produces = produceService.findAllByCondition(produceVO);
                if(produces.size()>0){
                    redisUtil.rightPushAll(BaseClassRedisKey.PRODUCECLASS_FINDALLBYCONDITIONNULL+produceVO.getPageNum()+"_"+produceVO.getPageSize(), produces);
                    //保存3天
                    redisUtil.pireKey(BaseClassRedisKey.PRODUCECLASS_FINDALLBYCONDITIONNULL+produceVO.getPageNum()+"_"+produceVO.getPageSize(), 3, TimeUnit.DAYS);
                }
            }
        } else {
            produces = produceService.findAllByCondition(produceVO);
        }
        PageInfo pageInfo=new PageInfo(produces);
        return JoeJSONResult.ok(pageInfo);
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
