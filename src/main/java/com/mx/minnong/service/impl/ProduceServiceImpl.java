package com.mx.minnong.service.impl;

import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.ProduceMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.vo.ProduceVO;
import com.mx.minnong.service.ProduceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/23 11:52
 */
@Service
@Slf4j
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private ProduceMapper produceMapper;

    @Override
    public List<Produce> findAllRecommend(Integer pro_recommend) {
        if (null == pro_recommend && "".equals(pro_recommend)) {
            log.info("【产品推荐查询】 推荐标识不能为空");
            throw new NetException(NetEnum.CLASS_ID_ISNOTEMPTY);
        }
        return produceMapper.findAllRecommend(pro_recommend);
    }

    @Override
    public List<Produce> findAllByCondition(ProduceVO produceVO) {
        return produceMapper.findAllByCondition(produceVO);
    }

    @Override
    public Produce findById(Integer proId) {
        if (null == proId && "".equals(proId)) {
            log.info("【根据产品ID查询】 产品ID不能为空");
            throw new NetException(NetEnum.CLASS_ID_ISNOTEMPTY);
        }
        return produceMapper.findById(proId);
    }
}
