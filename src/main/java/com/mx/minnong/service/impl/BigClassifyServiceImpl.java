package com.mx.minnong.service.impl;

import com.mx.minnong.mapper.BigclassifyMapper;
import com.mx.minnong.pojo.Bigclassify;
import com.mx.minnong.service.BigClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 13:54  2018/11/20
 * @Description:
 */
@Service
public class BigClassifyServiceImpl implements BigClassifyService {


    @Autowired
    private BigclassifyMapper bigclassifyMapper;

    @Override
    public List<Bigclassify> findAll() {
        return bigclassifyMapper.selectAll();
    }
}
