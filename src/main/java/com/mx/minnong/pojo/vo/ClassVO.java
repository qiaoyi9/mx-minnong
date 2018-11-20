package com.mx.minnong.pojo.vo;

import com.mx.minnong.pojo.Classify;
import com.mx.minnong.pojo.Kind;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:10  2018/11/20
 * @Description:
 */
public class ClassVO extends Classify {

    List<Kind> findList;

    public List<Kind> getFindList() {
        return findList;
    }

    public void setFindList(List<Kind> findList) {
        this.findList = findList;
    }

    public ClassVO(List<Kind> findList) {
        this.findList = findList;
    }

    public ClassVO() {
    }
}
