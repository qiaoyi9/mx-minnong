package com.mx.minnong.pojo.vo;
/*
 * 用于接收前台产品查询条件
 */
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/23 15:19
 */
public class ProduceVO {
    private Integer proId;
    private String proName;
    private Integer proClassify;
    private String proImg;
    private Integer proSclassify;
    private Date proUptimte;
    private Integer proRecommend;
    private String proProvince;
    private String proCity;
    private String proDistrict;
    private Integer proSeller;
    private Integer proBase;
    private Integer proAuditing;
    private Integer proBrowse;
    private BigDecimal proPrice;
    private String proYield;
    private Integer proKind;
    private String proContent;
    private Integer proLowest;
    private Integer proHighest;
    private Integer pageNum=1;
    private Integer pageSize=15;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getProClassify() {
        return proClassify;
    }

    public void setProClassify(Integer proClassify) {
        this.proClassify = proClassify;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public Integer getProSclassify() {
        return proSclassify;
    }

    public void setProSclassify(Integer proSclassify) {
        this.proSclassify = proSclassify;
    }

    public Date getProUptimte() {
        return proUptimte;
    }

    public void setProUptimte(Date proUptimte) {
        this.proUptimte = proUptimte;
    }

    public Integer getProRecommend() {
        return proRecommend;
    }

    public void setProRecommend(Integer proRecommend) {
        this.proRecommend = proRecommend;
    }

    public String getProProvince() {
        return proProvince;
    }

    public void setProProvince(String proProvince) {
        this.proProvince = proProvince;
    }

    public String getProCity() {
        return proCity;
    }

    public void setProCity(String proCity) {
        this.proCity = proCity;
    }

    public String getProDistrict() {
        return proDistrict;
    }

    public void setProDistrict(String proDistrict) {
        this.proDistrict = proDistrict;
    }

    public Integer getProSeller() {
        return proSeller;
    }

    public void setProSeller(Integer proSeller) {
        this.proSeller = proSeller;
    }

    public Integer getProBase() {
        return proBase;
    }

    public void setProBase(Integer proBase) {
        this.proBase = proBase;
    }

    public Integer getProAuditing() {
        return proAuditing;
    }

    public void setProAuditing(Integer proAuditing) {
        this.proAuditing = proAuditing;
    }

    public Integer getProBrowse() {
        return proBrowse;
    }

    public void setProBrowse(Integer proBrowse) {
        this.proBrowse = proBrowse;
    }

    public BigDecimal getProPrice() {
        return proPrice;
    }

    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    public String getProYield() {
        return proYield;
    }

    public void setProYield(String proYield) {
        this.proYield = proYield;
    }

    public Integer getProKind() {
        return proKind;
    }

    public void setProKind(Integer proKind) {
        this.proKind = proKind;
    }

    public String getProContent() {
        return proContent;
    }

    public void setProContent(String proContent) {
        this.proContent = proContent;
    }

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

    public ProduceVO(Integer proId, String proName, Integer proClassify, String proImg, Integer proSclassify, Date proUptimte, Integer proRecommend, String proProvince, String proCity, String proDistrict, Integer proSeller, Integer proBase, Integer proAuditing, Integer proBrowse, BigDecimal proPrice, String proYield, Integer proKind, String proContent, Integer proLowest, Integer proHighest, Integer pageNum, Integer pageSize) {
        this.proId = proId;
        this.proName = proName;
        this.proClassify = proClassify;
        this.proImg = proImg;
        this.proSclassify = proSclassify;
        this.proUptimte = proUptimte;
        this.proRecommend = proRecommend;
        this.proProvince = proProvince;
        this.proCity = proCity;
        this.proDistrict = proDistrict;
        this.proSeller = proSeller;
        this.proBase = proBase;
        this.proAuditing = proAuditing;
        this.proBrowse = proBrowse;
        this.proPrice = proPrice;
        this.proYield = proYield;
        this.proKind = proKind;
        this.proContent = proContent;
        this.proLowest = proLowest;
        this.proHighest = proHighest;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public ProduceVO() {
    }

    @Override
    public String toString() {
        return "ProduceVO{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proClassify=" + proClassify +
                ", proImg='" + proImg + '\'' +
                ", proSclassify=" + proSclassify +
                ", proUptimte=" + proUptimte +
                ", proRecommend=" + proRecommend +
                ", proProvince='" + proProvince + '\'' +
                ", proCity='" + proCity + '\'' +
                ", proDistrict='" + proDistrict + '\'' +
                ", proSeller=" + proSeller +
                ", proBase=" + proBase +
                ", proAuditing=" + proAuditing +
                ", proBrowse=" + proBrowse +
                ", proPrice=" + proPrice +
                ", proYield='" + proYield + '\'' +
                ", proKind=" + proKind +
                ", proContent='" + proContent + '\'' +
                ", proLowest=" + proLowest +
                ", proHighest=" + proHighest +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
