package com.mx.minnong.pojo.vo;

import lombok.Data;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 16:20  2018/11/27
 * @Description:
 */
public class PageVo {

    private Integer pageNum = 0;

    private Integer pageSize = 10;

    private Integer topNum=10;//前多少条数据

    public Integer getTopNum() {
        return topNum;
    }

    public void setTopNum(Integer topNum) {
        this.topNum = topNum;
    }

    public PageVo(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

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

    public PageVo() {
    }

}
