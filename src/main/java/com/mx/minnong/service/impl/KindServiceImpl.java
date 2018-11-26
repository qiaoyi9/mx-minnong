package com.mx.minnong.service.impl;

import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.KindMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.Kind;
import com.mx.minnong.service.KindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 14:58  2018/11/20
 * @Description:
 */
@Service
@Slf4j
public class KindServiceImpl implements KindService {

    @Autowired
    private KindMapper mapper;

    @Override
    public List<Kind> findAllByKindFid(Integer kindFid) {
        if (null == kindFid && "".equals(kindFid)){
            log.info("【产品类别查询】 父级id不能为空");
            throw new NetException(NetEnum.CLASS_ID_ISNOTEMPTY);
        }
        return mapper.findAllByKindFid(kindFid);
    }

    @Override
    public List<Kind> findAll() {
        return mapper.selectAll();
    }

    @Override
    public Kind findOne(Integer id) {
        if (null == id && "".equals(id)){
            log.info("【产品】");
        }
        return null;
    }
}
