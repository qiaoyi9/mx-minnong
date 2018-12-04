package com.mx.minnong.pojo;

import javax.persistence.*;

public class Company {
    @Id
    @Column(name = "com_id")
    private Integer comId;

    /**
     * 所属买家
     */
    @Column(name = "com_buyid")
    private Integer comBuyid;

    /**
     * 申请广告；1.是  2.否
     */
    @Column(name = "com_advert")
    private Integer comAdvert;

    /**
     * 申请推荐；1.是   2否
     */
    @Column(name = "com_recommend")
    private Integer comRecommend;

    /**
     * 详细介绍
     */
    @Column(name = "com_content")
    private String comContent;

    /**
     *  企业头图
     */
    @Column(name = "com_img")
    private String comImg;

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg;
    }

    /**
     * @return com_id
     */
    public Integer getComId() {
        return comId;
    }

    /**
     * @param comId
     */
    public void setComId(Integer comId) {
        this.comId = comId;
    }

    /**
     * 获取所属买家
     *
     * @return com_buyid - 所属买家
     */
    public Integer getComBuyid() {
        return comBuyid;
    }

    /**
     * 设置所属买家
     *
     * @param comBuyid 所属买家
     */
    public void setComBuyid(Integer comBuyid) {
        this.comBuyid = comBuyid;
    }

    /**
     * 获取申请广告；1.是  2.否
     *
     * @return com_advert - 申请广告；1.是  2.否
     */
    public Integer getComAdvert() {
        return comAdvert;
    }

    /**
     * 设置申请广告；1.是  2.否
     *
     * @param comAdvert 申请广告；1.是  2.否
     */
    public void setComAdvert(Integer comAdvert) {
        this.comAdvert = comAdvert;
    }

    /**
     * 获取申请推荐；1.是   2否
     *
     * @return com_recommend - 申请推荐；1.是   2否
     */
    public Integer getComRecommend() {
        return comRecommend;
    }

    /**
     * 设置申请推荐；1.是   2否
     *
     * @param comRecommend 申请推荐；1.是   2否
     */
    public void setComRecommend(Integer comRecommend) {
        this.comRecommend = comRecommend;
    }

    /**
     * 获取详细介绍
     *
     * @return com_content - 详细介绍
     */
    public String getComContent() {
        return comContent;
    }

    /**
     * 设置详细介绍
     *
     * @param comContent 详细介绍
     */
    public void setComContent(String comContent) {
        this.comContent = comContent;
    }
}