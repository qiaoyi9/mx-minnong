package com.mx.minnong.controller;

import com.mx.minnong.pojo.Bigclassify;
import com.mx.minnong.pojo.Classify;
import com.mx.minnong.pojo.Kind;
import com.mx.minnong.service.BigClassifyService;
import com.mx.minnong.service.ClassifyService;
import com.mx.minnong.service.KindService;
import com.mx.minnong.utils.JoeJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 14:39  2018/11/20
 * @Description: 加载首页分类
 */
@RestController
@RequestMapping("/BaseClass/")
@Slf4j
public class BaseClassController {

    @Autowired
    private BigClassifyService bigClassifyService;

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private KindService kindService;


    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 15:06 2018/11/20
     * @param: []
     * @return: com.mx.minnong.utils.JoeJSONResult
     * @methodName: findAll
     * @Description:
     */
    /*@RequestMapping("findAll")
    public JoeJSONResult findAll() {

        boolean classBaseData = redisTemplate.hasKey("baseClassData");
        if (classBaseData){

        }
        List<Bigclassify> bigclassifyList = bigClassifyService.findAll();
        List<Classify> classifyList = classifyService.findAll();

        *//*List<Bigclassify> bigclassifyList = new ArrayList<>();
        List<Bigclassify> bigclassifies = bigClassifyService.findAll();
        if (!bigclassifies.isEmpty()){
            for (Bigclassify big: bigclassifies) {
                if (big!=null){
                    List<Classify> classifies = classifyService.findAllByFid(big.getBclId());
                    if (classifies.isEmpty()){

                    }
                }
            }

        }*//*

     *//*List<BigClassVO> bigClassVOList = new ArrayList<>();
        List<ClassVO> classVOList = new ArrayList<>();
        BigClassVO bigClassVO = null;
        ClassVO classVO = null;
        List<Bigclassify> bigclassifyList = bigClassifyService.findAll();
        //判断大类查询返回结果是否为空
        if (!bigclassifyList.isEmpty() && null != bigclassifyList) {
            for (Bigclassify big : bigclassifyList) {
                if (big != null) {
                    bigClassVO = new BigClassVO();
                    //拷贝big对象到VO
                    BeanUtils.copyProperties(big, bigClassVO);
                    bigClassVOList.add(bigClassVO);
                    List<Classify> classifies = classifyService.findAllByFid(bigClassVO.getBclId());
                    //判断产品分类是否为空
                    if (null != classifies && !classifies.isEmpty()) {
                        for (Classify classify : classifies) {
                            if (classify != null) {
                                classVO = new ClassVO();
                                BeanUtils.copyProperties(classify, classVO);
                                bigClassVO.setClassVOList(classVOList);
                                List<Kind> kinds = kindService.findAllByKindFid(classVO.getClId());
                                if (null != kinds && !kinds.isEmpty()) {
                                    classVO.setFindList(kinds);
                                    classVOList.add(classVO);
                                    return JoeJSONResult.ok(bigClassVOList);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;*//*
    }*/

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 17:22 2018/11/20
     * @Description: 查询所有分类以及子类
     */
    @GetMapping("findAll")
    public JoeJSONResult findAll(){
        boolean key = redisTemplate.hasKey("baseclass");
        if (key){
            Map<String,List> hashMap = redisTemplate.opsForHash().entries("baseclass");
            return JoeJSONResult.ok(hashMap);
        }else {
            List<Bigclassify> bigclassifyList = bigClassifyService.findAll();
            List<Classify> classifyList = classifyService.findAll();
            List<Kind> kindList = kindService.findAll();
            HashMap<String,List> hashMap = new HashMap<String,List>();
            hashMap.put("bigclass",bigclassifyList);
            hashMap.put("class",classifyList);
            hashMap.put("kind",kindList);
            redisTemplate.opsForHash().putAll("baseclass",hashMap);
            return JoeJSONResult.ok(hashMap);
        }
    }


    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 17:32 2018/11/20
     * @param: [id]
     * @Description: 根据大分类id查询小分类
     */
    @RequestMapping("findClassByBigId/{id}")
    public JoeJSONResult findClassByBigId(@PathVariable Integer id){
        List<Classify> classifyList = classifyService.findAllByFid(id);
        return JoeJSONResult.ok(classifyList);
    }

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 16:19 2018/11/20
     * @Description: 查询所有大类
     */
    @GetMapping("BigClassFindAll")
    public JoeJSONResult bigClassFindAll() {
        boolean datanotempty = redisTemplate.hasKey("bigclassdata");
        if (datanotempty) {
            //reids存在数据
            List<Bigclassify> redisData = redisTemplate.opsForList().range("bigclassdata", 0, -1);
            return JoeJSONResult.ok(redisData);
        } else {
            log.info("【Get Redis Data】 BigClassify is null");
            //reids没有数据
            List<Bigclassify> bigclassifyList = bigClassifyService.findAll();
            if (!bigclassifyList.isEmpty()) {
                //写入redis
                redisTemplate.opsForList().rightPushAll("bigclassdata", bigclassifyList);
            }
            return JoeJSONResult.ok(bigclassifyList);
        }
    }
    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 16:19 2018/11/20
     * @Description: 查询小类
     */
    @GetMapping("ClassFindAll")
    public JoeJSONResult classFindAll() {
        boolean datanotempty = redisTemplate.hasKey("classdata");
        if (datanotempty) {
            //reids存在数据
            List<Classify> redisData = redisTemplate.opsForList().range("classdata", 0, -1);
            return JoeJSONResult.ok(redisData);
        } else {
            log.info("【Get Redis Data】 Classify is null");
            //reids没有数据
            List<Classify> classifies = classifyService.findAll();
            if (!classifies.isEmpty()) {
                //写入redis
                redisTemplate.opsForList().rightPushAll("classdata", classifies);
            }
            return JoeJSONResult.ok(classifies);
        }
    }

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 16:19 2018/11/20
     * @Description: 查询所有类目 kind
     */
    @GetMapping("KindFindAll")
    public JoeJSONResult kindFindAll() {
        boolean datanotempty = redisTemplate.hasKey("kinddata");
        if (datanotempty) {
            //reids存在数据
            List<Kind> redisData = redisTemplate.opsForList().range("kinddata", 0, -1);
            return JoeJSONResult.ok(redisData);
        } else {
            log.info("【Get Redis Data】 kinds is null");
            //reids没有数据
            List<Kind> kinds = kindService.findAll();
            if (!kinds.isEmpty()) {
                //写入redis
                redisTemplate.opsForList().rightPushAll("kinddata", kinds);
            }
            return JoeJSONResult.ok(kinds);
        }
    }

}
