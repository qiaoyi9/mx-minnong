package com.mx.minnong.pojo;

import com.mx.minnong.pojo.vo.SellerVo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

public class Produce implements Serializable {

    private static final long serialVersionUID = -3560295408523194487L;

    @Id
    @Column(name = "pro_id")
    private Integer proId;

    /**
     * 产品标题
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 卖家
     */
    private SellerVo sellerVo;

    public SellerVo getSellerVo() {
        return sellerVo;
    }

    public void setSellerVo(SellerVo sellerVo) {
        this.sellerVo = sellerVo;
    }

    /**
     * 产品图片
     * @return
     */
    private List<Proimg> proimgs;

    public List<Proimg> getProimgs() {
        return proimgs;
    }

    public void setProimgs(List<Proimg> proimgs) {
        this.proimgs = proimgs;
    }

    /**
     * 所属大分类
     */
    @Column(name = "pro_classify")
    private Integer proClassify;

    /**
     * 头图
     */
    @Column(name = "pro_img")
    private String proImg;

    /**
     * 所属小分类
     */
    @Column(name = "pro_sclassify")
    private Integer proSclassify;

    /**
     * 更新时间
     */
    @Column(name = "pro_uptimte")
    private Date proUptimte;

    /**
     * 是否推荐；1.是，2.否
     */
    @Column(name = "pro_recommend")
    private Integer proRecommend;

    /**
     * 所属省份
     */
    @Column(name = "pro_province")
    private String proProvince;

    /**
     * 所属市
     */
    @Column(name = "pro_city")
    private String proCity;

    /**
     * 所属区
     */
    @Column(name = "pro_district")
    private String proDistrict;

    /**
     * 所属卖家
     */
    @Column(name = "pro_seller")
    private Integer proSeller;

    /**
     * 关联基地
     */
    @Column(name = "pro_base")
    private Integer proBase;

    /**
     * 是否审核，1.是，2.否
     */
    @Column(name = "pro_auditing")
    private Integer proAuditing;

    /**
     * 浏览量
     */
    @Column(name = "pro_browse")
    private Integer proBrowse;

    /**
     * 商品价格
     */
    @Column(name = "pro_price")
    private BigDecimal proPrice;

    /**
     * 数量+单位  eg:50万吨
     */
    @Column(name = "pro_yield")
    private Integer proYield;

    /**
     * 商品种类
     */
    @Column(name = "pro_kind")
    private Integer proKind;

    /**
     * 商品单位
     */
    @Column(name="pro_unit")
    private String proUnit;
    /**
     * 详细介绍
     */
    @Column(name = "pro_content")
    private String proContent;

    public String getProUnit() {
        return proUnit;
    }

    public void setProUnit(String proUnit) {
        this.proUnit = proUnit;
    }

    /**
     * @return pro_id
     */
    public Integer getProId() {
        return proId;
    }

    /**
     * @param proId
     */
    public void setProId(Integer proId) {
        this.proId = proId;
    }

    /**
     * 获取产品标题
     *
     * @return pro_name - 产品标题
     */
    public String getProName() {
        return proName;
    }

    /**
     * 设置产品标题
     *
     * @param proName 产品标题
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * 获取所属大分类
     *
     * @return pro_classify - 所属大分类
     */
    public Integer getProClassify() {
        return proClassify;
    }

    /**
     * 设置所属大分类
     *
     * @param proClassify 所属大分类
     */
    public void setProClassify(Integer proClassify) {
        this.proClassify = proClassify;
    }

    /**
     * 获取头图
     *
     * @return pro_img - 头图
     */
    public String getProImg() {
        return proImg;
    }

    /**
     * 设置头图
     *
     * @param proImg 头图
     */
    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    /**
     * 获取所属小分类
     *
     * @return pro_sclassify - 所属小分类
     */
    public Integer getProSclassify() {
        return proSclassify;
    }

    /**
     * 设置所属小分类
     *
     * @param proSclassify 所属小分类
     */
    public void setProSclassify(Integer proSclassify) {
        this.proSclassify = proSclassify;
    }

    /**
     * 获取更新时间
     *
     * @return pro_uptimte - 更新时间
     */
    public Date getProUptimte() {
        return proUptimte;
    }

    /**
     * 设置更新时间
     *
     * @param proUptimte 更新时间
     */
    public void setProUptimte(Date proUptimte) {
        this.proUptimte = proUptimte;
    }

    /**
     * 获取是否推荐；1.是，2.否
     *
     * @return pro_recommend - 是否推荐；1.是，2.否
     */
    public Integer getProRecommend() {
        return proRecommend;
    }

    /**
     * 设置是否推荐；1.是，2.否
     *
     * @param proRecommend 是否推荐；1.是，2.否
     */
    public void setProRecommend(Integer proRecommend) {
        this.proRecommend = proRecommend;
    }

    /**
     * 获取所属省份
     *
     * @return pro_province - 所属省份
     */
    public String getProProvince() {
        return proProvince;
    }

    /**
     * 设置所属省份
     *
     * @param proProvince 所属省份
     */
    public void setProProvince(String proProvince) {
        this.proProvince = proProvince;
    }

    /**
     * 获取所属市
     *
     * @return pro_city - 所属市
     */
    public String getProCity() {
        return proCity;
    }

    /**
     * 设置所属市
     *
     * @param proCity 所属市
     */
    public void setProCity(String proCity) {
        this.proCity = proCity;
    }

    /**
     * 获取所属区
     *
     * @return pro_district - 所属区
     */
    public String getProDistrict() {
        return proDistrict;
    }

    /**
     * 设置所属区
     *
     * @param proDistrict 所属区
     */
    public void setProDistrict(String proDistrict) {
        this.proDistrict = proDistrict;
    }

    /**
     * 获取所属卖家
     *
     * @return pro_seller - 所属卖家
     */
    public Integer getProSeller() {
        return proSeller;
    }

    /**
     * 设置所属卖家
     *
     * @param proSeller 所属卖家
     */
    public void setProSeller(Integer proSeller) {
        this.proSeller = proSeller;
    }

    /**
     * 获取关联基地
     *
     * @return pro_base - 关联基地
     */
    public Integer getProBase() {
        return proBase;
    }

    /**
     * 设置关联基地
     *
     * @param proBase 关联基地
     */
    public void setProBase(Integer proBase) {
        this.proBase = proBase;
    }

    /**
     * 获取是否审核，1.是，2.否
     *
     * @return pro_auditing - 是否审核，1.是，2.否
     */
    public Integer getProAuditing() {
        return proAuditing;
    }

    /**
     * 设置是否审核，1.是，2.否
     *
     * @param proAuditing 是否审核，1.是，2.否
     */
    public void setProAuditing(Integer proAuditing) {
        this.proAuditing = proAuditing;
    }

    /**
     * 获取浏览量
     *
     * @return pro_browse - 浏览量
     */
    public Integer getProBrowse() {
        return proBrowse;
    }

    /**
     * 设置浏览量
     *
     * @param proBrowse 浏览量
     */
    public void setProBrowse(Integer proBrowse) {
        this.proBrowse = proBrowse;
    }

    /**
     * 获取商品价格
     *
     * @return pro_price - 商品价格
     */
    public BigDecimal getProPrice() {
        return proPrice;
    }

    /**
     * 设置商品价格
     *
     * @param proPrice 商品价格
     */
    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    /**
     * 获取数量+单位  eg:50万吨
     *
     * @return pro_yield - 数量+单位  eg:50万吨
     */
    public Integer getProYield() {
        return proYield;
    }

    /**
     * 设置数量+单位  eg:50万吨
     *
     * @param proYield 数量+单位  eg:50万吨
     */
    public void setProYield(Integer proYield) {
        this.proYield = proYield;
    }

    /**
     * 获取商品种类
     *
     * @return pro_kind - 商品种类
     */
    public Integer getProKind() {
        return proKind;
    }

    /**
     * 设置商品种类
     *
     * @param proKind 商品种类
     */
    public void setProKind(Integer proKind) {
        this.proKind = proKind;
    }

    /**
     * 获取详细介绍
     *
     * @return pro_content - 详细介绍
     */
    public String getProContent() {
        return proContent;
    }

    /**
     * 设置详细介绍
     *
     * @param proContent 详细介绍
     */
    public void setProContent(String proContent) {
        this.proContent = proContent;
    }
}