package com.mx.minnong.pojo;

import javax.persistence.*;

public class Classify {
    @Id
    @Column(name = "cl_id")
    private Integer clId;

    /**
     * 父类id
     */
    @Column(name = "cl_fid")
    private Integer clFid;

    /**
     * 名字
     */
    @Column(name = "cla_name")
    private String claName;

    /**
     * @return cl_id
     */
    public Integer getClId() {
        return clId;
    }

    /**
     * @param clId
     */
    public void setClId(Integer clId) {
        this.clId = clId;
    }

    /**
     * 获取父类id
     *
     * @return cl_fid - 父类id
     */
    public Integer getClFid() {
        return clFid;
    }

    /**
     * 设置父类id
     *
     * @param clFid 父类id
     */
    public void setClFid(Integer clFid) {
        this.clFid = clFid;
    }

    /**
     * 获取名字
     *
     * @return cla_name - 名字
     */
    public String getClaName() {
        return claName;
    }

    /**
     * 设置名字
     *
     * @param claName 名字
     */
    public void setClaName(String claName) {
        this.claName = claName;
    }
}