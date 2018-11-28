package com.mx.minnong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

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
     * 是否会员  1.是  0.否
     */
    @Column(name = "sel_ismem")
    private boolean selIsmem;

    /**
     * 最后登录ip
     */
    @Column(name = "sel_lastIp")
    private String selLastip;

    /**
     * 最后一次登录时间
     */
    @Column(name = "sel_lastLoginTime")
    private Date selLastlogintime;

    /**
     * 创建时间
     */
    @Column(name = "sel_createTime")
    private Date selCreatetime;

    /**
     * 是否验证
     */
    @Column(name = "sel_frozen")
    private boolean selFrozen;

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

    /**
     * 获取是否会员  1.是  0.否
     *
     * @return sel_ismem - 是否会员  1.是  0.否
     */
    public boolean isSelIsmem() {
        return selIsmem;
    }

    /**
     * 设置是否会员  1.是  0.否
     *
     * @param selIsmem 是否会员  1.是  0.否
     */
    public void setSelIsmem(boolean selIsmem) {
        this.selIsmem = selIsmem;
    }

    /**
     * 获取最后登录ip
     *
     * @return sel_lastIp - 最后登录ip
     */
    public String getSelLastip() {
        return selLastip;
    }

    /**
     * 设置最后登录ip
     *
     * @param selLastip 最后登录ip
     */
    public void setSelLastip(String selLastip) {
        this.selLastip = selLastip;
    }

    /**
     * 获取最后一次登录时间
     *
     * @return sel_lastLoginTime - 最后一次登录时间
     */
    public Date getSelLastlogintime() {
        return selLastlogintime;
    }

    /**
     * 设置最后一次登录时间
     *
     * @param selLastlogintime 最后一次登录时间
     */
    public void setSelLastlogintime(Date selLastlogintime) {
        this.selLastlogintime = selLastlogintime;
    }

    /**
     * 获取创建时间
     *
     * @return sel_createTime - 创建时间
     */
    public Date getSelCreatetime() {
        return selCreatetime;
    }

    /**
     * 设置创建时间
     *
     * @param selCreatetime 创建时间
     */
    public void setSelCreatetime(Date selCreatetime) {
        this.selCreatetime = selCreatetime;
    }

    /**
     * 获取是否验证
     *
     * @return sel_frozen - 是否验证
     */
    public boolean isSelFrozen() {
        return selFrozen;
    }

    /**
     * 设置是否验证
     *
     * @param selFrozen 是否验证
     */
    public void setSelFrozen(boolean selFrozen) {
        this.selFrozen = selFrozen;
    }
}