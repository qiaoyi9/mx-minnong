package com.mx.minnong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class Bigclassify implements Serializable {
    private static final long serialVersionUID = -8147953826141017214L;
    @Id
    @Column(name = "bcl_id")
    private Integer bclId;

    /**
     * 名字
     */
    @Column(name = "bcl_name")
    private String bclName;

<<<<<<< HEAD
    @Column(name = "bcl_icon")
    private  String bclIcon;


    private List<Classify> classifies;

    public List<Classify> getClassifies() {
        return classifies;
    }

    public void setClassifies(List<Classify> classifies) {
        this.classifies = classifies;
    }
=======
    /**
     * 大类图标
     */
    @Column(name = "bcl_icon")
    private String bclIcon;
>>>>>>> c62cd5d95f96d006928450c83826473bc3f05b6e


    public String getBclIcon() {
        return bclIcon;
    }

    public void setBclIcon(String bclIcon) {
        this.bclIcon = bclIcon;
    }

    /**
     * @return bcl_id
     */
    public Integer getBclId() {
        return bclId;
    }

    /**
     * @param bclId
     */
    public void setBclId(Integer bclId) {
        this.bclId = bclId;
    }

    /**
     * 获取名字
     *
     * @return bcl_name - 名字
     */
    public String getBclName() {
        return bclName;
    }

    /**
     * 设置名字
     *
     * @param bclName 名字
     */
    public void setBclName(String bclName) {
        this.bclName = bclName;
    }

    /**
     * 获取大类图标
     *
     * @return bcl_icon - 大类图标
     */
    public String getBclIcon() {
        return bclIcon;
    }

    /**
     * 设置大类图标
     *
     * @param bclIcon 大类图标
     */
    public void setBclIcon(String bclIcon) {
        this.bclIcon = bclIcon;
    }
}