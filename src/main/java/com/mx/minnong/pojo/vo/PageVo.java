package com.mx.minnong.pojo.vo;


/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 16:20  2018/11/27
 * @Description:
 */
public class PageVo {

    private Integer pageNum = 0;

    private Integer pageSize = 10;

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

    @Override
    public String toString() {
        return "PageVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
