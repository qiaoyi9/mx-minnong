package com.mx.minnong.pojo;

import javax.persistence.*;

public class Offer {
    @Id
    @Column(name = "offer_id")
    private Integer offerId;

    /**
     * 商品ID
     */
    @Column(name = "offer_proid")
    private Integer offerProid;

    /**
     * 买家ID
     */
    @Column(name = "offer_buyid")
    private Integer offerBuyid;

    /**
     * 报价
     */
    @Column(name = "offer_price")
    private Integer offerPrice;

    /**
     * 买家ID
     */
    @Column(name = "offer_selid")
    private Integer offerSelid;

    /**
     * 是否采纳  1.是  2.否
     */
    @Column(name = "offer_adopt")
    private Integer offerAdopt;

    /**
     * @return offer_id
     */
    public Integer getOfferId() {
        return offerId;
    }

    /**
     * @param offerId
     */
    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    /**
     * 获取商品ID
     *
     * @return offer_proid - 商品ID
     */
    public Integer getOfferProid() {
        return offerProid;
    }

    /**
     * 设置商品ID
     *
     * @param offerProid 商品ID
     */
    public void setOfferProid(Integer offerProid) {
        this.offerProid = offerProid;
    }

    /**
     * 获取买家ID
     *
     * @return offer_buyid - 买家ID
     */
    public Integer getOfferBuyid() {
        return offerBuyid;
    }

    /**
     * 设置买家ID
     *
     * @param offerBuyid 买家ID
     */
    public void setOfferBuyid(Integer offerBuyid) {
        this.offerBuyid = offerBuyid;
    }

    /**
     * 获取报价
     *
     * @return offer_price - 报价
     */
    public Integer getOfferPrice() {
        return offerPrice;
    }

    /**
     * 设置报价
     *
     * @param offerPrice 报价
     */
    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
    }

    /**
     * 获取买家ID
     *
     * @return offer_selid - 买家ID
     */
    public Integer getOfferSelid() {
        return offerSelid;
    }

    /**
     * 设置买家ID
     *
     * @param offerSelid 买家ID
     */
    public void setOfferSelid(Integer offerSelid) {
        this.offerSelid = offerSelid;
    }

    /**
     * 获取是否采纳  1.是  2.否
     *
     * @return offer_adopt - 是否采纳  1.是  2.否
     */
    public Integer getOfferAdopt() {
        return offerAdopt;
    }

    /**
     * 设置是否采纳  1.是  2.否
     *
     * @param offerAdopt 是否采纳  1.是  2.否
     */
    public void setOfferAdopt(Integer offerAdopt) {
        this.offerAdopt = offerAdopt;
    }
}