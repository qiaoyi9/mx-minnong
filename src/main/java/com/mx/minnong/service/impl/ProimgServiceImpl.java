package com.mx.minnong.service.impl;

import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.ProduceMapper;
import com.mx.minnong.mapper.ProimgMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.Proimg;
import com.mx.minnong.service.ProimgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/29 15:59
 */
@Slf4j
@Service
public class ProimgServiceImpl implements ProimgService {

    @Autowired
    private ProimgMapper proimgMapper;

    @Override
    public List<Proimg> findByProimgPro(Integer proimgPro) {
        return null;
    }
}
