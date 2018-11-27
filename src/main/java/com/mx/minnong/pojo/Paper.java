package com.mx.minnong.pojo;

import javax.persistence.*;

public class Paper {

    @Id
    @Column(name = "paper_id")
    private Integer paperId;

    /**
     * 标题
     */
    @Column(name = "paper_title")
    private String paperTitle;

    /**
     * 来源
     */
    @Column(name = "paper_source")
    private String paperSource;

    /**
     * 所属分类
     */
    @Column(name = "paper_kind")
    private Integer paperKind;

    /**
     * 所属地区
     */
    @Column(name = "paper_region")
    private String paperRegion;

    /**
     * 是否显示  1.是  2 否
     */
    @Column(name = "paper_status")
    private Integer paperStatus;

    /**
     * 地址
     */
    @Column(name = "paper_address")
    private String paperAddress;

    /**
     * @return paper_id
     */
    public Integer getPaperId() {
        return paperId;
    }

    /**
     * @param paperId
     */
    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    /**
     * 获取标题
     *
     * @return paper_title - 标题
     */
    public String getPaperTitle() {
        return paperTitle;
    }

    /**
     * 设置标题
     *
     * @param paperTitle 标题
     */
    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    /**
     * 获取来源
     *
     * @return paper_source - 来源
     */
    public String getPaperSource() {
        return paperSource;
    }

    /**
     * 设置来源
     *
     * @param paperSource 来源
     */
    public void setPaperSource(String paperSource) {
        this.paperSource = paperSource;
    }

    /**
     * 获取所属分类
     *
     * @return paper_kind - 所属分类
     */
    public Integer getPaperKind() {
        return paperKind;
    }

    /**
     * 设置所属分类
     *
     * @param paperKind 所属分类
     */
    public void setPaperKind(Integer paperKind) {
        this.paperKind = paperKind;
    }

    /**
     * 获取所属地区
     *
     * @return paper_region - 所属地区
     */
    public String getPaperRegion() {
        return paperRegion;
    }

    /**
     * 设置所属地区
     *
     * @param paperRegion 所属地区
     */
    public void setPaperRegion(String paperRegion) {
        this.paperRegion = paperRegion;
    }

    /**
     * 获取是否显示  1.是  2 否
     *
     * @return paper_status - 是否显示  1.是  2 否
     */
    public Integer getPaperStatus() {
        return paperStatus;
    }

    /**
     * 设置是否显示  1.是  2 否
     *
     * @param paperStatus 是否显示  1.是  2 否
     */
    public void setPaperStatus(Integer paperStatus) {
        this.paperStatus = paperStatus;
    }

    /**
     * 获取地址
     *
     * @return paper_address - 地址
     */
    public String getPaperAddress() {
        return paperAddress;
    }

    /**
     * 设置地址
     *
     * @param paperAddress 地址
     */
    public void setPaperAddress(String paperAddress) {
        this.paperAddress = paperAddress;
    }
}