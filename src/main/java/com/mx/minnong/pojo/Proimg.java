package com.mx.minnong.pojo;

import javax.persistence.*;

public class Proimg {
    /**
     * 商品图片表
     */
    @Column(name = "proimg_id")
    private Integer proimgId;

    /**
     * 商品id
     */
    @Column(name = "proimg_pro")
    private Integer proimgPro;

    /**
     * 图片路径
     */
    @Column(name = "proimg_path")
    private String proimgPath;

    /**
     * 获取商品图片表
     *
     * @return proimg_id - 商品图片表
     */
    public Integer getProimgId() {
        return proimgId;
    }

    /**
     * 设置商品图片表
     *
     * @param proimgId 商品图片表
     */
    public void setProimgId(Integer proimgId) {
        this.proimgId = proimgId;
    }

    /**
     * 获取商品id
     *
     * @return proimg_pro - 商品id
     */
    public Integer getProimgPro() {
        return proimgPro;
    }

    /**
     * 设置商品id
     *
     * @param proimgPro 商品id
     */
    public void setProimgPro(Integer proimgPro) {
        this.proimgPro = proimgPro;
    }

    /**
     * 获取图片路径
     *
     * @return proimg_path - 图片路径
     */
    public String getProimgPath() {
        return proimgPath;
    }

    /**
     * 设置图片路径
     *
     * @param proimgPath 图片路径
     */
    public void setProimgPath(String proimgPath) {
        this.proimgPath = proimgPath;
    }
}