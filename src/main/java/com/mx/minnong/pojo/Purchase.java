package com.mx.minnong.pojo;

import java.util.Date;
import javax.persistence.*;

public class Purchase {
    @Id
    @Column(name = "pur_id")
    private Integer purId;

    /**
     * 求购商品
     */
    @Column(name = "pur_produce")
    private String purProduce;

    /**
     * 买家ID
     */
    @Column(name = "pur_buyid")
    private Integer purBuyid;

    /**
     * 状态  1.采购中  2.已过期  3.长期有效
     */
    @Column(name = "per_status")
    private Integer perStatus;

    /**
     * 采购数量（XX吨）
     */
    @Column(name = "pur_number")
    private String purNumber;

    /**
     * 发布时间
     */
    @Column(name = "pur_begin")
    private Date purBegin;

    /**
     * 截止时间
     */
    @Column(name = "pur_endtime")
    private Date purEndtime;

    /**
     * 期望采购地
     */
    @Column(name = "pur_address")
    private String purAddress;

    /**
     * @return pur_id
     */
    public Integer getPurId() {
        return purId;
    }

    /**
     * @param purId
     */
    public void setPurId(Integer purId) {
        this.purId = purId;
    }

    /**
     * 获取求购商品
     *
     * @return pur_produce - 求购商品
     */
    public String getPurProduce() {
        return purProduce;
    }

    /**
     * 设置求购商品
     *
     * @param purProduce 求购商品
     */
    public void setPurProduce(String purProduce) {
        this.purProduce = purProduce;
    }

    /**
     * 获取买家ID
     *
     * @return pur_buyid - 买家ID
     */
    public Integer getPurBuyid() {
        return purBuyid;
    }

    /**
     * 设置买家ID
     *
     * @param purBuyid 买家ID
     */
    public void setPurBuyid(Integer purBuyid) {
        this.purBuyid = purBuyid;
    }

    /**
     * 获取状态  1.采购中  2.已过期  3.长期有效
     *
     * @return per_status - 状态  1.采购中  2.已过期  3.长期有效
     */
    public Integer getPerStatus() {
        return perStatus;
    }

    /**
     * 设置状态  1.采购中  2.已过期  3.长期有效
     *
     * @param perStatus 状态  1.采购中  2.已过期  3.长期有效
     */
    public void setPerStatus(Integer perStatus) {
        this.perStatus = perStatus;
    }

    /**
     * 获取采购数量（XX吨）
     *
     * @return pur_number - 采购数量（XX吨）
     */
    public String getPurNumber() {
        return purNumber;
    }

    /**
     * 设置采购数量（XX吨）
     *
     * @param purNumber 采购数量（XX吨）
     */
    public void setPurNumber(String purNumber) {
        this.purNumber = purNumber;
    }

    /**
     * 获取发布时间
     *
     * @return pur_begin - 发布时间
     */
    public Date getPurBegin() {
        return purBegin;
    }

    /**
     * 设置发布时间
     *
     * @param purBegin 发布时间
     */
    public void setPurBegin(Date purBegin) {
        this.purBegin = purBegin;
    }

    /**
     * 获取截止时间
     *
     * @return pur_endtime - 截止时间
     */
    public Date getPurEndtime() {
        return purEndtime;
    }

    /**
     * 设置截止时间
     *
     * @param purEndtime 截止时间
     */
    public void setPurEndtime(Date purEndtime) {
        this.purEndtime = purEndtime;
    }

    /**
     * 获取期望采购地
     *
     * @return pur_address - 期望采购地
     */
    public String getPurAddress() {
        return purAddress;
    }

    /**
     * 设置期望采购地
     *
     * @param purAddress 期望采购地
     */
    public void setPurAddress(String purAddress) {
        this.purAddress = purAddress;
    }
}