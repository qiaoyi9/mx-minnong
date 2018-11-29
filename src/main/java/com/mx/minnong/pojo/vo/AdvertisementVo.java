package com.mx.minnong.pojo.vo;

import com.mx.minnong.pojo.Produce;

import java.util.Date;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/29 13:47
 */
public class AdvertisementVo {
    private Integer adverId;
    private Integer adverProid;
    private Date adverBegintime;
    private Date adverEndtime;
    private Integer adverState;
    private Integer adverPosition;
    private Produce produce;

    public Integer getAdverId() {
        return adverId;
    }

    public void setAdverId(Integer adverId) {
        this.adverId = adverId;
    }

    public Integer getAdverProid() {
        return adverProid;
    }

    public void setAdverProid(Integer adverProid) {
        this.adverProid = adverProid;
    }

    public Date getAdverBegintime() {
        return adverBegintime;
    }

    public void setAdverBegintime(Date adverBegintime) {
        this.adverBegintime = adverBegintime;
    }

    public Date getAdverEndtime() {
        return adverEndtime;
    }

    public void setAdverEndtime(Date adverEndtime) {
        this.adverEndtime = adverEndtime;
    }

    public Integer getAdverState() {
        return adverState;
    }

    public void setAdverState(Integer adverState) {
        this.adverState = adverState;
    }

    public Integer getAdverPosition() {
        return adverPosition;
    }

    public void setAdverPosition(Integer adverPosition) {
        this.adverPosition = adverPosition;
    }

    public Produce getProduce() {
        return produce;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }
}
