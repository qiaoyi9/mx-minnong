package com.mx.minnong.service;

import com.mx.minnong.pojo.News;
import com.mx.minnong.pojo.vo.PageVo;

import java.util.List;

/**
 * @Author: 乔一
 * @createtime 2018-11-28 15:32
 **/
public interface NewsService {

    News findOne(Integer id);

    int saveNews(News news);

    int updateNews(News news);

    List<News> findAll(PageVo pageVo);

    int deleteNews(Integer id);
}
