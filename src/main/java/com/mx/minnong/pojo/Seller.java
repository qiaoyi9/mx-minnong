package com.mx.minnong.pojo;

import javax.persistence.*;

public class Seller {
    @Id
    @Column(name = "sel_id")
    private Integer selId;

    /**
     * 登录密码
     */
    @Column(name = "sel_psd")
    private String selPsd;

    /**
     * 名字（某某的养殖场、果林、某某合作社）
     */
    @Column(name = "sel_name")
    private String selName;

    /**
     * 联系人
     */
    @Column(name = "sel_contacts")
    private String selContacts;

    /**
     * 联系电话
     */
    @Column(name = "sel_tel")
    private String selTel;

    /**
     * 验证邮箱
     */
    @Column(name = "sel_email")
    private String selEmail;

    /**
     * 关联商品集合（中间用逗号隔开）
     */
    @Column(name = "sel_produceid")
    private String selProduceid;

    /**
     * 关联基地集合（中间用逗号隔开）
     */
    @Column(name = "sel_base")
    private String selBase;

    /**
     * 申请的广告集合
     */
    @Column(name = "sel_advertisement")
    private String selAdvertisement;

    /**
     * @return sel_id
     */
    public Integer getSelId() {
        return selId;
    }

    /**
     * @param selId
     */
    public void setSelId(Integer selId) {
        this.selId = selId;
    }

    /**
     * 获取登录密码
     *
     * @return sel_psd - 登录密码
     */
    public String getSelPsd() {
        return selPsd;
    }

    /**
     * 设置登录密码
     *
     * @param selPsd 登录密码
     */
    public void setSelPsd(String selPsd) {
        this.selPsd = selPsd;
    }

    /**
     * 获取名字（某某的养殖场、果林、某某合作社）
     *
     * @return sel_name - 名字（某某的养殖场、果林、某某合作社）
     */
    public String getSelName() {
        return selName;
    }

    /**
     * 设置名字（某某的养殖场、果林、某某合作社）
     *
     * @param selName 名字（某某的养殖场、果林、某某合作社）
     */
    public void setSelName(String selName) {
        this.selName = selName;
    }

    /**
     * 获取联系人
     *
     * @return sel_contacts - 联系人
     */
    public String getSelContacts() {
        return selContacts;
    }

    /**
     * 设置联系人
     *
     * @param selContacts 联系人
     */
    public void setSelContacts(String selContacts) {
        this.selContacts = selContacts;
    }

    /**
     * 获取联系电话
     *
     * @return sel_tel - 联系电话
     */
    public String getSelTel() {
        return selTel;
    }

    /**
     * 设置联系电话
     *
     * @param selTel 联系电话
     */
    public void setSelTel(String selTel) {
        this.selTel = selTel;
    }

    /**
     * 获取验证邮箱
     *
     * @return sel_email - 验证邮箱
     */
    public String getSelEmail() {
        return selEmail;
    }

    /**
     * 设置验证邮箱
     *
     * @param selEmail 验证邮箱
     */
    public void setSelEmail(String selEmail) {
        this.selEmail = selEmail;
    }

    /**
     * 获取关联商品集合（中间用逗号隔开）
     *
     * @return sel_produceid - 关联商品集合（中间用逗号隔开）
     */
    public String getSelProduceid() {
        return selProduceid;
    }

    /**
     * 设置关联商品集合（中间用逗号隔开）
     *
     * @param selProduceid 关联商品集合（中间用逗号隔开）
     */
    public void setSelProduceid(String selProduceid) {
        this.selProduceid = selProduceid;
    }

    /**
     * 获取关联基地集合（中间用逗号隔开）
     *
     * @return sel_base - 关联基地集合（中间用逗号隔开）
     */
    public String getSelBase() {
        return selBase;
    }

    /**
     * 设置关联基地集合（中间用逗号隔开）
     *
     * @param selBase 关联基地集合（中间用逗号隔开）
     */
    public void setSelBase(String selBase) {
        this.selBase = selBase;
    }

    /**
     * 获取申请的广告集合
     *
     * @return sel_advertisement - 申请的广告集合
     */
    public String getSelAdvertisement() {
        return selAdvertisement;
    }

    /**
     * 设置申请的广告集合
     *
     * @param selAdvertisement 申请的广告集合
     */
    public void setSelAdvertisement(String selAdvertisement) {
        this.selAdvertisement = selAdvertisement;
    }
}