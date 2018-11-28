package com.mx.minnong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Buyer {
    @Id
    @Column(name = "buy_id")
    private Integer buyId;

    /**
     * 登录密码
     */
    @Column(name = "buy_psd")
    private String buyPsd;

    @Column(name = "buy_name")
    private String buyName;

    /**
     * 联系人
     */
    @Column(name = "buy_contacts")
    private String buyContacts;

    /**
     * 联系电话
     */
    @Column(name = "buy_tel")
    private String buyTel;

    @Column(name = "buy_email")
    private String buyEmail;

    /**
     * 收藏的商品集合（中间用逗号隔开）
     */
    @Column(name = "buy_collection")
    private String buyCollection;

    /**
     * 管理企业展示
     */
    @Column(name = "buy_comid")
    private Integer buyComid;

    /**
     * 申请的广告集合
     */
    @Column(name = "buy_advertisement")
    private String buyAdvertisement;

    /**
     * 是否会员  1.是  0.否
     */
    @Column(name = "buy_ismem")
    private boolean buyIsmem;

    /**
     * 最后登录ip
     */
    @Column(name = "buy_lastIp")
    private String buyLastip;

    /**
     * 最后一次登录时间
     */
    @Column(name = "buy_lastLoginTime")
    private Date buyLastlogintime;

    /**
     * 创建时间
     */
    @Column(name = "buy_createTime")
    private Date buyCreatetime;

    /**
     * 是否验证
     */
    @Column(name = "buy_frozen")
    private boolean buyFrozen;

    /**
     * @return buy_id
     */
    public Integer getBuyId() {
        return buyId;
    }

    /**
     * @param buyId
     */
    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    /**
     * 获取登录密码
     *
     * @return buy_psd - 登录密码
     */
    public String getBuyPsd() {
        return buyPsd;
    }

    /**
     * 设置登录密码
     *
     * @param buyPsd 登录密码
     */
    public void setBuyPsd(String buyPsd) {
        this.buyPsd = buyPsd;
    }

    /**
     * @return buy_name
     */
    public String getBuyName() {
        return buyName;
    }

    /**
     * @param buyName
     */
    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    /**
     * 获取联系人
     *
     * @return buy_contacts - 联系人
     */
    public String getBuyContacts() {
        return buyContacts;
    }

    /**
     * 设置联系人
     *
     * @param buyContacts 联系人
     */
    public void setBuyContacts(String buyContacts) {
        this.buyContacts = buyContacts;
    }

    /**
     * 获取联系电话
     *
     * @return buy_tel - 联系电话
     */
    public String getBuyTel() {
        return buyTel;
    }

    /**
     * 设置联系电话
     *
     * @param buyTel 联系电话
     */
    public void setBuyTel(String buyTel) {
        this.buyTel = buyTel;
    }

    /**
     * @return buy_email
     */
    public String getBuyEmail() {
        return buyEmail;
    }

    /**
     * @param buyEmail
     */
    public void setBuyEmail(String buyEmail) {
        this.buyEmail = buyEmail;
    }

    /**
     * 获取收藏的商品集合（中间用逗号隔开）
     *
     * @return buy_collection - 收藏的商品集合（中间用逗号隔开）
     */
    public String getBuyCollection() {
        return buyCollection;
    }

    /**
     * 设置收藏的商品集合（中间用逗号隔开）
     *
     * @param buyCollection 收藏的商品集合（中间用逗号隔开）
     */
    public void setBuyCollection(String buyCollection) {
        this.buyCollection = buyCollection;
    }

    /**
     * 获取管理企业展示
     *
     * @return buy_comid - 管理企业展示
     */
    public Integer getBuyComid() {
        return buyComid;
    }

    /**
     * 设置管理企业展示
     *
     * @param buyComid 管理企业展示
     */
    public void setBuyComid(Integer buyComid) {
        this.buyComid = buyComid;
    }

    /**
     * 获取申请的广告集合
     *
     * @return buy_advertisement - 申请的广告集合
     */
    public String getBuyAdvertisement() {
        return buyAdvertisement;
    }

    /**
     * 设置申请的广告集合
     *
     * @param buyAdvertisement 申请的广告集合
     */
    public void setBuyAdvertisement(String buyAdvertisement) {
        this.buyAdvertisement = buyAdvertisement;
    }

    /**
     * 获取是否会员  1.是  0.否
     *
     * @return buy_ismem - 是否会员  1.是  0.否
     */
    public boolean isBuyIsmem() {
        return buyIsmem;
    }

    /**
     * 设置是否会员  1.是  0.否
     *
     * @param buyIsmem 是否会员  1.是  0.否
     */
    public void setBuyIsmem(boolean buyIsmem) {
        this.buyIsmem = buyIsmem;
    }

    /**
     * 获取最后登录ip
     *
     * @return buy_lastIp - 最后登录ip
     */
    public String getBuyLastip() {
        return buyLastip;
    }

    /**
     * 设置最后登录ip
     *
     * @param buyLastip 最后登录ip
     */
    public void setBuyLastip(String buyLastip) {
        this.buyLastip = buyLastip;
    }

    /**
     * 获取最后一次登录时间
     *
     * @return buy_lastLoginTime - 最后一次登录时间
     */
    public Date getBuyLastlogintime() {
        return buyLastlogintime;
    }

    /**
     * 设置最后一次登录时间
     *
     * @param buyLastlogintime 最后一次登录时间
     */
    public void setBuyLastlogintime(Date buyLastlogintime) {
        this.buyLastlogintime = buyLastlogintime;
    }

    /**
     * 获取创建时间
     *
     * @return buy_createTime - 创建时间
     */
    public Date getBuyCreatetime() {
        return buyCreatetime;
    }

    /**
     * 设置创建时间
     *
     * @param buyCreatetime 创建时间
     */
    public void setBuyCreatetime(Date buyCreatetime) {
        this.buyCreatetime = buyCreatetime;
    }

    /**
     * 获取是否验证
     *
     * @return buy_frozen - 是否验证
     */
    public boolean isBuyFrozen() {
        return buyFrozen;
    }

    /**
     * 设置是否验证
     *
     * @param buyFrozen 是否验证
     */
    public void setBuyFrozen(boolean buyFrozen) {
        this.buyFrozen = buyFrozen;
    }
}