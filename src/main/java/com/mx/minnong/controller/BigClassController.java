package com.mx.minnong.controller;

import com.mx.minnong.pojo.Bigclassify;
import com.mx.minnong.service.BigClassifyService;
import com.mx.minnong.utils.JoeJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 13:56  2018/11/20
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/bigClass/")
public class BigClassController {

    @Autowired
    private BigClassifyService bigClassifyService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 13:59 2018/11/20
     * @return: JoeJSONResult
     * @Description: 查询首页大类
     */
    @GetMapping("findAll")
    public JoeJSONResult findAll(){
        boolean keyEmpty = redisTemplate.hasKey("bigClassifyList");
        //查看redis是否存在数据
        if (keyEmpty){
            List<Bigclassify> redisData = redisTemplate.opsForList().range("bigClassifyList",0,-1);
            return JoeJSONResult.ok(redisData);
        }else {
            log.info("【产品大类查询】 redis data is null");
            List<Bigclassify> bigclassifyList = bigClassifyService.findAll();
            if (null != bigclassifyList && !bigclassifyList.isEmpty()){
                //保存到redis
                redisTemplate.opsForList().rightPushAll("bigClassifyList",bigclassifyList);
            }
            return JoeJSONResult.ok(bigclassifyList);
        }
    }

}
