package com.mx.minnong.pojo;

import java.util.Date;
import javax.persistence.*;

public class Advertisement {
    @Id
    @Column(name = "adver_id")
    private Integer adverId;

    /**
     * 商品ID
     */
    @Column(name = "adver_proid")
    private Integer adverProid;

    /**
     * 开始申请时间
     */
    @Column(name = "adver_begintime")
    private Date adverBegintime;

    /**
     * 结束时间
     */
    @Column(name = "adver_endtime")
    private Date adverEndtime;

    /**
     * 状态；1.投放中，2.已过期，3.未审核
     */
    @Column(name = "adver_state")
    private Integer adverState;



    /**
     * 投放位置
     */
    @Column(name = "adver_position")
    private Integer adverPosition;


    /**
     * 商品
     */
    private Produce produce;

    public Produce getProduce() {
        return produce;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    /**
     * @return adver_id
     */
    public Integer getAdverId() {
        return adverId;
    }

    /**
     * @param adverId
     */
    public void setAdverId(Integer adverId) {
        this.adverId = adverId;
    }

    /**
     * 获取商品ID
     *
     * @return adver_proid - 商品ID
     */
    public Integer getAdverProid() {
        return adverProid;
    }

    /**
     * 设置商品ID
     *
     * @param adverProid 商品ID
     */
    public void setAdverProid(Integer adverProid) {
        this.adverProid = adverProid;
    }

    /**
     * 获取开始申请时间
     *
     * @return adver_begintime - 开始申请时间
     */
    public Date getAdverBegintime() {
        return adverBegintime;
    }

    /**
     * 设置开始申请时间
     *
     * @param adverBegintime 开始申请时间
     */
    public void setAdverBegintime(Date adverBegintime) {
        this.adverBegintime = adverBegintime;
    }

    /**
     * 获取结束时间
     *
     * @return adver_endtime - 结束时间
     */
    public Date getAdverEndtime() {
        return adverEndtime;
    }

    /**
     * 设置结束时间
     *
     * @param adverEndtime 结束时间
     */
    public void setAdverEndtime(Date adverEndtime) {
        this.adverEndtime = adverEndtime;
    }

    /**
     * 获取状态；1.投放中，2.已过期，3.未审核
     *
     * @return adver_state - 状态；1.投放中，2.已过期，3.未审核
     */
    public Integer getAdverState() {
        return adverState;
    }

    /**
     * 设置状态；1.投放中，2.已过期，3.未审核
     *
     * @param adverState 状态；1.投放中，2.已过期，3.未审核
     */
    public void setAdverState(Integer adverState) {
        this.adverState = adverState;
    }

    /**
     * 获取投放位置
     *
     * @return adver_position - 投放位置
     */
    public Integer getAdverPosition() {
        return adverPosition;
    }

    /**
     * 设置投放位置
     *
     * @param adverPosition 投放位置
     */
    public void setAdverPosition(Integer adverPosition) {
        this.adverPosition = adverPosition;
    }
}