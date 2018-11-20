package com.mx.minnong.service.impl;

import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.ClassifyMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.Classify;
import com.mx.minnong.service.ClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:15  2018/11/20
 * @Description:
 */
@Service
@Slf4j
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public List<Classify> findAllByFid(Integer fId) {
        if (null == fId && "".equals(fId)) {
            log.info("【产品类别查询】 父级id不能为空");
            throw new NetException(NetEnum.CLASS_ID_ISNOTEMPTY);
        }
        return classifyMapper.findAllByFid(fId);
    }

    @Override
    public List<Classify> findAll() {
        return classifyMapper.selectAll();
    }
}
