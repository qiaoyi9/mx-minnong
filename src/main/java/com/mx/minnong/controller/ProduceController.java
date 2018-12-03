package com.mx.minnong.controller;

import com.github.pagehelper.PageInfo;
import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.vo.PageVo;
import com.mx.minnong.pojo.vo.ProduceVO;
import com.mx.minnong.service.ProduceService;
import com.mx.minnong.utils.BaseClassRedisKey;
import com.mx.minnong.utils.IpUtil;
import com.mx.minnong.utils.JoeJSONResult;
import com.mx.minnong.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
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


    @RequestMapping(value ="findAllByCondition01")
    public JoeJSONResult findAllByCondition01(ProduceVO produceVO){
        System.out.println(produceVO.getProName());
        List<Produce> produces = produceService.findAllByCondition(produceVO);
        PageInfo pageInfo=new PageInfo(produces);
        return JoeJSONResult.ok(pageInfo);
    }

    /**
     *
     * 热门权值不做失效?
     * 热门商品默认前十
     * @param pageVo
     * @return
     */
    @RequestMapping("findHot")
    public JoeJSONResult findHot(PageVo pageVo){
        List<Produce> produces= produceService.findHot(pageVo);
        PageInfo pageInfo =new PageInfo(produces);
        return JoeJSONResult.ok(pageInfo);
    }

    /**
     * 根据大类小类种类和省份市区价格条件获得产品  pro_lowest最低价格 pro_highest最高价格
     */
    @RequestMapping(value ="findAllByCondition")
    public JoeJSONResult findAllByCondition(ProduceVO produceVO) throws IllegalAccessException{
        String key=BaseClassRedisKey.PRODUCECLASS_FINDALLBYCONDITIONNULL;
        List<Produce> produces=new ArrayList<Produce>();
        boolean flag = true;
        Class produceVOClass = produceVO.getClass();
        //produceVOClass = produceVOClass.getSuperclass() 得到父类的class文件
            Field[] field = produceVOClass.getDeclaredFields();
                for (Field f : field) {
                f.setAccessible(true);
                if (!"".equals(f.get(produceVO)) && (f.get(produceVO) != null) && !(f.getName().equals("pageNum") || f.getName().equals("pageSize"))) {
                    flag = false;
                    break;
                } // System.out.println("属性："+f.getName()+" 值："+f.get(produceVO));
            }
        if (flag) {
            if (redisUtil.existsKey(key+produceVO.getPageNum()+"_"+produceVO.getPageSize())) {
                produces = redisUtil.range(key+produceVO.getPageNum()+"_"+produceVO.getPageSize());
                System.out.println(produces.size());
            } else {
                log.info("【Get Redis Data】 findAllByCondition is null ");
                produces = produceService.findAllByCondition(produceVO);
                if(produces.size()>0){
                    redisUtil.rightPushAll(key+produceVO.getPageNum()+"_"+produceVO.getPageSize(), produces);
                    //保存3小时
                    redisUtil.pireKey(key+produceVO.getPageNum()+"_"+produceVO.getPageSize(), 3, TimeUnit.HOURS);
                }
            }
        } else {
            produces = produceService.findAllByCondition(produceVO);
        }
        PageInfo pageInfo=new PageInfo(produces);
        return JoeJSONResult.ok(pageInfo);
    }

    /**
     * 根据ID获得商品
     * 没查询一次 商品浏览量加一
     * @param proId
     * @return
     */
    @RequestMapping(value ="findById")
    public JoeJSONResult findById(@RequestParam("proId") Integer proId){
        String key =BaseClassRedisKey.BASECLASS_PRODUCEIDVIEWS;
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String IP=IpUtil.getIpAddr(request);
        Long num=redisUtil.sadd("IP",IP);
        if(num>0){
            redisUtil.incr(key,proId);
        }
        Produce produce=produceService.findById(proId);
        return JoeJSONResult.ok(produce);
    }
    /**
     *
     * @param pageVo
     * @param proSeller
     * @return
     */
    @RequestMapping("findByProseller")
    public JoeJSONResult findByProseller(PageVo pageVo,@RequestParam Integer proSeller){
        System.out.println(pageVo.getPageSize());
        System.out.println(proSeller);
        List<Produce> produces=produceService.findByProseller(pageVo,proSeller);
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
