package com.mx.minnong.controller;

import com.mx.minnong.pojo.Bigclassify;
import com.mx.minnong.pojo.Classify;
import com.mx.minnong.pojo.Kind;
import com.mx.minnong.service.BigClassifyService;
import com.mx.minnong.service.ClassifyService;
import com.mx.minnong.service.KindService;
import com.mx.minnong.utils.BaseClassRedisKey;
import com.mx.minnong.utils.JoeJSONResult;
import com.mx.minnong.utils.RedisUtil;
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
    private KindService kindService;


    @Autowired
    private RedisUtil redisUtil;

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 17:22 2018/11/20
     * @Description: 查询所有分类以及子类
     */
    @GetMapping("fzindAll")
    public JoeJSONResult findAll(){
        if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_FINDALL)){
            Map<String,List> hashMap = redisUtil.entries(BaseClassRedisKey.BASECLASS_FINDALL);
            return JoeJSONResult.ok(hashMap);
        }else {
            log.info("【Get Redis Data】 findAll is null");
            List<Bigclassify> bigclassifyList = bigClassifyService.findAll();
            List<Classify> classifyList = classifyService.findAll();
            List<Kind> kindList = kindService.findAll();

            HashMap<String,List> hashMap = new HashMap<String,List>();
            hashMap.put("bigclass",bigclassifyList);
            hashMap.put("class",classifyList);
            hashMap.put("kind",kindList);
            redisUtil.putAll(BaseClassRedisKey.BASECLASS_FINDALL,hashMap);
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
        //避免redis key重复  将此id作为盐值拼接key
        if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_FINDCLASSBYBIGID+id)){
            List<Classify> classifies = redisUtil.range(BaseClassRedisKey.BASECLASS_FINDCLASSBYBIGID+id);
            return JoeJSONResult.ok(classifies);
        }else {
            log.info("【Get Redis Data】 findClassByBigId is null id={}",id);
            List<Classify> classifyList = classifyService.findAllByFid(id);
            if (!classifyList.isEmpty()){
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_FINDCLASSBYBIGID+id,classifyList);
            }
            return JoeJSONResult.ok(classifyList);
        }

    }

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 17:32 2018/11/20
     * @param: [id]
     * @Description: 根据子分类id类产品
     */
    @RequestMapping("findKindByClassId/{id}")
    public JoeJSONResult findKindByClassId(@PathVariable Integer id){
        if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_FINDKINDBYCLASSID+id)){
            List<Kind> kinds = redisUtil.range(BaseClassRedisKey.BASECLASS_FINDKINDBYCLASSID+id);
            return JoeJSONResult.ok(kinds);
        }else {
            log.info("【Get Redis Data】 findKindByClassId is null id={}",id);
            List<Kind> kindList = kindService.findAllByKindFid(id);
            if (!kindList.isEmpty()){
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_FINDKINDBYCLASSID+id,kindList);
            }
            return JoeJSONResult.ok(kindList);
        }
    }

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 16:19 2018/11/20
     * @Description: 查询所有大类
     */
    @GetMapping("BigClassFindAll")
    public JoeJSONResult bigClassFindAll() {
        if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_BIGCLASSFINDALL)) {
            //reids存在数据
            List<Bigclassify> redisData = redisUtil.range(BaseClassRedisKey.BASECLASS_BIGCLASSFINDALL);
            return JoeJSONResult.ok(redisData);
        } else {
            log.info("【Get Redis Data】 BigClassify is null");
            //reids没有数据
            List<Bigclassify> bigclassifyList = bigClassifyService.findAll();
            if (!bigclassifyList.isEmpty()) {
                //写入redis
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_BIGCLASSFINDALL,bigclassifyList);
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
        if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_CLASSFINDALL)) {
            //reids存在数据
            List<Classify> redisData = redisUtil.range(BaseClassRedisKey.BASECLASS_CLASSFINDALL);
            return JoeJSONResult.ok(redisData);
        } else {
            log.info("【Get Redis Data】 Classify is null");
            //reids没有数据
            List<Classify> classifies = classifyService.findAll();
            if (!classifies.isEmpty()) {
                //写入redis
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_CLASSFINDALL,classifies);
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
        if (redisUtil.existsKey(BaseClassRedisKey.BASECLASS_KINDFINDALL)) {
            //reids存在数据
            List<Kind> redisData = redisUtil.range(BaseClassRedisKey.BASECLASS_KINDFINDALL);
            return JoeJSONResult.ok(redisData);
        } else {
            log.info("【Get Redis Data】 kinds is null");
            //reids没有数据
            List<Kind> kinds = kindService.findAll();
            if (!kinds.isEmpty()) {
                redisUtil.rightPushAll(BaseClassRedisKey.BASECLASS_KINDFINDALL, kinds);
            }
            return JoeJSONResult.ok(kinds);
        }
    }




}
