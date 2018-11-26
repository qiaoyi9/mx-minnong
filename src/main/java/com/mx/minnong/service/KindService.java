package com.mx.minnong.service;
/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 14:58  2018/11/20
 * @Description:
 */

import com.mx.minnong.pojo.Kind;

import java.util.List;

/**
 * @Author: 乔一
 * @createtime 2018-11-20 14:58
 **/
public interface KindService {

    //根据Classfiy id 查询子类
    List<Kind> findAllByKindFid(Integer kindFid);

    List<Kind> findAll();

    Kind findOne(Integer id);
}
