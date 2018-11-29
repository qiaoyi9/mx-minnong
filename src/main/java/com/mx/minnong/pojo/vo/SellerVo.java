package com.mx.minnong.pojo.vo;

import java.io.Serializable;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/28 15:50
 */
public class SellerVo implements Serializable {

    private static final long serialVersionUID = -3037309417091279972L;

    private Integer selId;
    private String selName;
    private String selContacts;
    private String selTel;
    private String selEmail;
    private String selLastip;

    public Integer getSelId() {
        return selId;
    }

    public void setSelId(Integer selId) {
        this.selId = selId;
    }

    public String getSelName() {
        return selName;
    }

    public void setSelName(String selName) {
        this.selName = selName;
    }

    public String getSelContacts() {
        return selContacts;
    }

    public void setSelContacts(String selContacts) {
        this.selContacts = selContacts;
    }

    public String getSelTel() {
        return selTel;
    }

    public void setSelTel(String selTel) {
        this.selTel = selTel;
    }

    public String getSelEmail() {
        return selEmail;
    }

    public void setSelEmail(String selEmail) {
        this.selEmail = selEmail;
    }

    public String getSelLastip() {
        return selLastip;
    }

    public void setSelLastip(String selLastip) {
        this.selLastip = selLastip;
    }

    @Override
    public String toString() {
        return "SellerVo{" +
                "selId=" + selId +
                ", selName='" + selName + '\'' +
                ", selContacts='" + selContacts + '\'' +
                ", selTel='" + selTel + '\'' +
                ", selEmail='" + selEmail + '\'' +
                ", selLastip='" + selLastip + '\'' +
                '}';
    }
}
