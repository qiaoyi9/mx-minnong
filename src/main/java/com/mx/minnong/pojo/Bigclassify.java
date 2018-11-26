package com.mx.minnong.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class Bigclassify implements Serializable {

    private static final long serialVersionUID = 4423424357048055575L;
    @Id
    @Column(name = "bcl_id")
    private Integer bclId;

    /**
     * 名字
     */
    @Column(name = "bcl_name")
    private String bclName;



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

    @Override
    public String toString() {
        return "Bigclassify{" +
                "bclId=" + bclId +
                ", bclName='" + bclName ;
    }
}