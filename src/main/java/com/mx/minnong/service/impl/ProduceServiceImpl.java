package com.mx.minnong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.ProduceMapper;
import com.mx.minnong.mapper.ProimgMapper;
import com.mx.minnong.mapper.SellerMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.Produce;
import com.mx.minnong.pojo.Proimg;
import com.mx.minnong.pojo.Seller;
import com.mx.minnong.pojo.vo.PageVo;
import com.mx.minnong.pojo.vo.ProduceVO;
import com.mx.minnong.pojo.vo.SellerVo;
import com.mx.minnong.service.ProduceService;
import com.mx.minnong.utils.BaseClassRedisKey;
import com.mx.minnong.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/11/23 11:52
 */
@Service
@Slf4j
public class ProduceServiceImpl implements ProduceService {


    @Autowired
    private ProduceMapper produceMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private ProimgMapper proimgMapper;


    @Override
    public List<Produce> findAllRecommend(Integer pro_recommend) {
        if (null == pro_recommend && "".equals(pro_recommend)) {
            log.info("【产品推荐查询】 推荐标识不能为空");
            throw new NetException(NetEnum.CLASS_ID_ISNOTEMPTY);
        }
        return produceMapper.findAllRecommend(pro_recommend);
    }

    /**
     *
     * @param produceVO
     * @return
     * @Description 根据大类小类种类和省份市区价格条件获得产品
     * pro_lowest最低价格 pro_highest最高价格
     */
    @Override
    public List<Produce> findAllByCondition(ProduceVO produceVO) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(produceVO.getPageNum(),produceVO.getPageSize());
        List<Produce> lists=produceMapper.findAllByCondition(produceVO);
        return lists;
    }

    /**
     * @Description 点击浏览商品
     * @param proId
     * @return
     */
    @Override
    public Produce findById(Integer proId) {
        if (null == proId && "".equals(proId)) {
            log.info("【根据产品ID查询】 产品ID不能为空");
            throw new NetException(NetEnum.CLASS_ID_ISNOTEMPTY);
        }
        SellerVo sellerVo=new SellerVo();
        Produce produce=produceMapper.findById(proId);
        if(produce!=null){
            Seller seller=sellerMapper.selectByPrimaryKey(produce.getProSeller());
            if(seller!=null){
                sellerVo.setSelId(seller.getSelId());
                sellerVo.setSelContacts(seller.getSelContacts());
                sellerVo.setSelEmail(seller.getSelEmail());
                sellerVo.setSelName(seller.getSelName());
                sellerVo.setSelLastip(seller.getSelLastip());
                sellerVo.setSelTel(seller.getSelTel());
                produce.setSellerVo(sellerVo);
            }
            List<Proimg> proimgs= proimgMapper.findByProimgPro(produce.getProId());
            if(proimgs.size()>0){
                produce.setProimgs(proimgs);
            }
        }
        return produce;
    }

    /**
     *
     * @Description 热门权值不做失效? 热门商品默认前十
     *
     * tomNum
     * @return
     */
    @Override
    public List<Produce> findHot(PageVo pageVo) {
        String keyAll=BaseClassRedisKey.BASECLASS_PRODUCEIDVIEWS;//所有的商品id与访问量
        String key=BaseClassRedisKey.BASECLASS_PRODUCEFINDHOT;//热门商品用于拼接
        Set<Object>  proIds=null;
        Integer pageNum=pageVo.getPageNum();
        Integer pageSize=pageVo.getPageSize();
        Integer topNum=(pageVo.getTopNum()-1);
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        List<Produce> produces= new ArrayList<>();
        if(redisUtil.existsKey(keyAll)){
            if(redisUtil.existsKey(key+pageNum+pageSize+topNum)){
                produces=redisUtil.range(key);
            }else{
                proIds=redisUtil.reverseRange(keyAll,topNum);
                for (Object id: proIds
                ) {
                    produces.add(produceMapper.findById((Integer)id));
                }
                redisUtil.rightPushAll(key+pageNum+pageSize+topNum,produces);
                //时间待定
                redisUtil.pireKey(key+pageNum+pageSize+topNum,1, TimeUnit.DAYS);
            }
        }else{
            List<Produce> list=new ArrayList<>();
            list=produceMapper.selectAll();
            for (Produce produce: list
            ) {
                redisUtil.zadd(keyAll,produce.getProId(),produce.getProBrowse());
            }
            proIds=redisUtil.reverseRange(keyAll,topNum);
            for (Object id: proIds
            ) {
                produces.add(produceMapper.findById((Integer)id));
            }
            redisUtil.rightPushAll(key+pageNum+pageSize+topNum,produces);
            //时间待定
            redisUtil.pireKey(key+pageNum+pageSize+topNum,1, TimeUnit.DAYS);
        }
        return produces;
    }

    /**
     * @Description 根据卖家ID获得商品
     * @param pageVo
     * @param proSeller
     * @return
     */
    @Override
    public List<Produce> findByProseller(PageVo pageVo,Integer proSeller) {
        if(proSeller==null || "".equals(proSeller)){
            log.info("【根据卖家ID查询】 卖家ID不能为空");
            throw new NetException(NetEnum.PROSELLER_ISNOTEMPTY);
        }
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<Produce> produces=produceMapper.findByProseller(proSeller);
        return produces;
    }
}
