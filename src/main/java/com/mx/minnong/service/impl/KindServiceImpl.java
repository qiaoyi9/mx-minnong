package com.mx.minnong.service.impl;

import com.mx.minnong.mapper.KindMapper;
import com.mx.minnong.pojo.Kind;
import com.mx.minnong.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 14:58  2018/11/20
 * @Description:
 */
@Service
public class KindServiceImpl implements KindService {

    @Autowired
    private KindMapper mapper;

    @Override
    public List<Kind> findAllByKindFid(Integer kindFid) {

        return mapper.findAllByKindFid(kindFid);
    }

    @Override
    public List<Kind> findAll() {
        return mapper.selectAll();
    }
}
