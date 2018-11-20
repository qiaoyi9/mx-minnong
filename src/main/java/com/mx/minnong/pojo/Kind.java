package com.mx.minnong.pojo;

import javax.persistence.*;

public class Kind {
    @Id
    @Column(name = "kind_id")
    private Integer kindId;

    /**
     * 父类ID
     */
    @Column(name = "kind_fid")
    private Integer kindFid;

    /**
     * 分类名
     */
    @Column(name = "kind_name")
    private String kindName;

    /**
     * @return kind_id
     */
    public Integer getKindId() {
        return kindId;
    }

    /**
     * @param kindId
     */
    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    /**
     * 获取父类ID
     *
     * @return kind_fid - 父类ID
     */
    public Integer getKindFid() {
        return kindFid;
    }

    /**
     * 设置父类ID
     *
     * @param kindFid 父类ID
     */
    public void setKindFid(Integer kindFid) {
        this.kindFid = kindFid;
    }

    /**
     * 获取分类名
     *
     * @return kind_name - 分类名
     */
    public String getKindName() {
        return kindName;
    }

    /**
     * 设置分类名
     *
     * @param kindName 分类名
     */
    public void setKindName(String kindName) {
        this.kindName = kindName;
    }
}