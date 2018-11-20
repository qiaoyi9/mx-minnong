package com.mx.minnong.pojo;

import javax.persistence.*;

public class Base {
    @Id
    @Column(name = "base_id")
    private Integer baseId;

    /**
     * 基地名
     */
    @Column(name = "base_name")
    private String baseName;

    /**
     * 所属卖家
     */
    @Column(name = "base_seller")
    private Integer baseSeller;

    /**
     * 相关商品
     */
    @Column(name = "base_produceid")
    private String baseProduceid;

    /**
     * 申请广告；1.是  2.否
     */
    @Column(name = "base_advert")
    private Integer baseAdvert;

    /**
     * 申请推荐；1.是   2否
     */
    @Column(name = "base_recommend")
    private Integer baseRecommend;

    /**
     * 详细介绍
     */
    @Column(name = "base_content")
    private String baseContent;

    /**
     * @return base_id
     */
    public Integer getBaseId() {
        return baseId;
    }

    /**
     * @param baseId
     */
    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    /**
     * 获取基地名
     *
     * @return base_name - 基地名
     */
    public String getBaseName() {
        return baseName;
    }

    /**
     * 设置基地名
     *
     * @param baseName 基地名
     */
    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    /**
     * 获取所属卖家
     *
     * @return base_seller - 所属卖家
     */
    public Integer getBaseSeller() {
        return baseSeller;
    }

    /**
     * 设置所属卖家
     *
     * @param baseSeller 所属卖家
     */
    public void setBaseSeller(Integer baseSeller) {
        this.baseSeller = baseSeller;
    }

    /**
     * 获取相关商品
     *
     * @return base_produceid - 相关商品
     */
    public String getBaseProduceid() {
        return baseProduceid;
    }

    /**
     * 设置相关商品
     *
     * @param baseProduceid 相关商品
     */
    public void setBaseProduceid(String baseProduceid) {
        this.baseProduceid = baseProduceid;
    }

    /**
     * 获取申请广告；1.是  2.否
     *
     * @return base_advert - 申请广告；1.是  2.否
     */
    public Integer getBaseAdvert() {
        return baseAdvert;
    }

    /**
     * 设置申请广告；1.是  2.否
     *
     * @param baseAdvert 申请广告；1.是  2.否
     */
    public void setBaseAdvert(Integer baseAdvert) {
        this.baseAdvert = baseAdvert;
    }

    /**
     * 获取申请推荐；1.是   2否
     *
     * @return base_recommend - 申请推荐；1.是   2否
     */
    public Integer getBaseRecommend() {
        return baseRecommend;
    }

    /**
     * 设置申请推荐；1.是   2否
     *
     * @param baseRecommend 申请推荐；1.是   2否
     */
    public void setBaseRecommend(Integer baseRecommend) {
        this.baseRecommend = baseRecommend;
    }

    /**
     * 获取详细介绍
     *
     * @return base_content - 详细介绍
     */
    public String getBaseContent() {
        return baseContent;
    }

    /**
     * 设置详细介绍
     *
     * @param baseContent 详细介绍
     */
    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }
}