package com.mx.minnong.controller;

import com.github.pagehelper.PageInfo;
import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.Recommend;
import com.mx.minnong.pojo.vo.PageVo;
import com.mx.minnong.service.ProduceService;
import com.mx.minnong.service.RecommendService;
import com.mx.minnong.utils.JoeJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/26 11:38
 */
@RestController
@RequestMapping("/recommend/")
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    @Autowired
    private ProduceService produceService;

    //首页产品推荐
    @RequestMapping("findAll")
    public JoeJSONResult findAll(PageVo pageVo) {
        List<Recommend> listRecommend = new ArrayList<>();
        List<Produce> listProduce = new ArrayList<>();
        listRecommend = recommendService.findAll(pageVo);
        if (listRecommend.size() > 0) {
            for (Recommend r : listRecommend) {
                listProduce.add(produceService.findById(r.getRecId()));
            }

        }
        PageInfo pageInfo = new PageInfo(listProduce);
        return JoeJSONResult.ok(pageInfo);
    }
}