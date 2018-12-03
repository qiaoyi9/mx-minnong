package com.mx.minnong.controller;

import com.github.pagehelper.PageInfo;
import com.mx.minnong.pojo.Recommend;
import com.mx.minnong.pojo.vo.PageVo;
import com.mx.minnong.service.RecommendService;
import com.mx.minnong.utils.JoeJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/26 11:38
 */
@RestController
@RequestMapping("/recommend/")
@Slf4j
public class RecommendController {

    @Autowired
    private RecommendService recommendService;


    //首页产品推荐
    @RequestMapping("findAll")
    public JoeJSONResult findAll(PageVo pageVo) {
        List<Recommend> recommends=recommendService.findAll(pageVo);
        PageInfo pageInfo = new PageInfo(recommends);
        return JoeJSONResult.ok(pageInfo);
    }
}