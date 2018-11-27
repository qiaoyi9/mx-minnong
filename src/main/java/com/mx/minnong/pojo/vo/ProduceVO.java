package com.mx.minnong.pojo.vo;
/*
 * 用于接收前台产品查询条件
 */
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/23 15:19
 */
@Data
public class ProduceVO {

    private Integer proId;
    private String proName;
    private Integer proClassify;
    private String proImg;
    private Integer proSclassify;
    private Date proUptimte;
    private Integer proRecommend;
    private String proProvince;
    private String proCity;
    private String proDistrict;
    private Integer proSeller;
    private Integer proBase;
    private Integer proAuditing;
    private Integer proBrowse;
    private BigDecimal proPrice;
    private String proYield;
    private Integer proKind;
    private String proContent;
    private Integer proLowest;
    private Integer proHighest;

}
