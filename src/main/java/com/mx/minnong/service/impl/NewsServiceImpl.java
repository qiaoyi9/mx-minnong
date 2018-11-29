package com.mx.minnong.service.impl;

import com.github.pagehelper.PageHelper;
import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.NewsMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.News;
import com.mx.minnong.pojo.vo.PageVo;
import com.mx.minnong.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:36  2018/11/28
 */
@Slf4j
@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public News findOne(Integer id) {
        if ("".equals(id) && null == id){
            log.info("【查询新闻 id不能为空】");
            throw new NetException(NetEnum.ID_ISEMPTY);
        }else {
            return newsMapper.selectByPrimaryKey(id);
        }
    }

    @Override
    public int saveNews(News news) {
        return newsMapper.insertSelective(news);
    }

    @Override
    public int updateNews(News news) {
        if ("".equals(news.getNewsId()) && null == news.getNewsId()){
            log.info("【修改新闻 id不能为空】");
            throw new NetException(NetEnum.ID_ISEMPTY);
        }else {
            return newsMapper.updateByPrimaryKeySelective(news);
        }
    }

    @Override
    public List<News> findAll(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize(),"news_createTime DESC");
        return newsMapper.selectAll();
    }

    @Override
    public int deleteNews(Integer id) {
        if ("".equals(id) && null == id){
            log.info("【删除新闻 id不能为空】");
            throw new NetException(NetEnum.ID_ISEMPTY);
        }else {
            return newsMapper.deleteByPrimaryKey(id);
        }
    }
}
