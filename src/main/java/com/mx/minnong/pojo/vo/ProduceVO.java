package com.mx.minnong.pojo.vo;

import com.mx.minnong.pojo.Produce;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/23 15:19
 */
public class ProduceVO extends Produce {
    private Integer proLowest;
    private Integer proHighest;

    public Integer getProLowest() {
        return proLowest;
    }

    public void setProLowest(Integer proLowest) {
        this.proLowest = proLowest;
    }

    public Integer getProHighest() {
        return proHighest;
    }

    public void setProHighest(Integer proHighest) {
        this.proHighest = proHighest;
    }

    @Override
    public String toString() {
        return "ProduceVO{" +
                "proLowest=" + proLowest +
                ", proHighest=" + proHighest +
                '}';
    }
}
