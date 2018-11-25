package com.mx.minnong.pojo.vo;

import com.mx.minnong.pojo.Bigclassify;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:10  2018/11/20
 * @Description:
 */
public class BigClassVO extends Bigclassify {

    List<ClassVO> classVOList;

    public BigClassVO() {

    }

    public List<ClassVO> getClassVOList() {
        return classVOList;
    }

    public void setClassVOList(List<ClassVO> classVOList) {
        this.classVOList = classVOList;
    }

    public BigClassVO(List<ClassVO> classVOList) {
        this.classVOList = classVOList;
    }
}
