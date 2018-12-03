package com.mx.minnong.pojo;

import java.util.Date;
import javax.persistence.*;

public class Recommend {
    @Id
    @Column(name = "rec_id")
    private Integer recId;

    /**
     * 关联产品ID
     */
    @Column(name = "rec_proid")
    private Integer recProid;

    /**
     * 开始推荐时间
     */
    @Column(name = "rec_begintime")
    private Date recBegintime;

    /**
     * 推荐到期时间
     */
    @Column(name = "ren_endtime")
    private Date renEndtime;


    /**
     * 产品
     */
    private Produce produce;

    public Produce getProduce() {
        return produce;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    /**
     * @return rec_id
     */
    public Integer getRecId() {
        return recId;
    }

    /**
     * @param recId
     */
    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    /**
     * 获取关联产品ID
     *
     * @return rec_proid - 关联产品ID
     */
    public Integer getRecProid() {
        return recProid;
    }

    /**
     * 设置关联产品ID
     *
     * @param recProid 关联产品ID
     */
    public void setRecProid(Integer recProid) {
        this.recProid = recProid;
    }

    /**
     * 获取开始推荐时间
     *
     * @return rec_begintime - 开始推荐时间
     */
    public Date getRecBegintime() {
        return recBegintime;
    }

    /**
     * 设置开始推荐时间
     *
     * @param recBegintime 开始推荐时间
     */
    public void setRecBegintime(Date recBegintime) {
        this.recBegintime = recBegintime;
    }

    /**
     * 获取推荐到期时间
     *
     * @return ren_endtime - 推荐到期时间
     */
    public Date getRenEndtime() {
        return renEndtime;
    }

    /**
     * 设置推荐到期时间
     *
     * @param renEndtime 推荐到期时间
     */
    public void setRenEndtime(Date renEndtime) {
        this.renEndtime = renEndtime;
    }
}