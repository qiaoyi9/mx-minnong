package com.mx.minnong.controller;

import com.github.pagehelper.PageInfo;
import com.mx.minnong.exception.NetException;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.News;
import com.mx.minnong.pojo.vo.PageVo;
import com.mx.minnong.service.NewsService;
import com.mx.minnong.utils.ApiRootPath;
import com.mx.minnong.utils.FastDFSClient;
import com.mx.minnong.utils.JoeJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:45  2018/11/28
 * @Description: 新闻控制类
 */
@RequestMapping("/News/")
@RestController
@Slf4j
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * @param: [id]
     * 查询单条新闻
     */
    @RequestMapping(value = "api/{id}",method = RequestMethod.GET)
    public JoeJSONResult findOne(@PathVariable Integer id){
        News news = newsService.findOne(id);
        return JoeJSONResult.ok(news);
    }

    /**
     * @param: [pageNum pageSize]
     * 查询多条新闻  分页查询
     */
    @RequestMapping(value = "api",method = RequestMethod.GET)
    public JoeJSONResult findAll(PageVo pageVo){
        //TODO 新闻查询 生产环境redis缓存
        List<News> news = newsService.findAll(pageVo);
        PageInfo<News> pageInfo = new PageInfo<News>(news);
        return JoeJSONResult.ok(pageInfo);
    }

    /**
     * @param: [news]
     * 添加新闻需要权限 path > root
     */
    @RequestMapping(value = ApiRootPath.ROOTPATH+"api",method = RequestMethod.POST)
    public JoeJSONResult AddNews(News news){
        //TODO 添加新闻  set 新闻发布人  上传图片
        int result = newsService.saveNews(news);
        return JoeJSONResult.ok("添加成功");
    }

    /**
     * @param: [id,news]
     * 修改新闻需要权限 path > root
     */
    @RequestMapping(value = ApiRootPath.ROOTPATH+"api/{id}",method = RequestMethod.PUT)
    public JoeJSONResult updateNews(@PathVariable Integer id,News news){
        if (null != id && !"".equals(id)){
            news.setNewsId(id);
            System.out.println(new Date().toString());
            news.setNewsUpdatetime(new Date());
            int result = newsService.updateNews(news);
            return JoeJSONResult.ok("修改成功");
        }else {
            log.error("【修改新闻】 id参数为空 news={}",news);
            throw new NetException(NetEnum.ID_ISEMPTY);
        }
    }

    /**
     * @param: [id]
     * 删除新闻 如果新闻存在图片删除图片
     */
    @RequestMapping(value = ApiRootPath.ROOTPATH+"api/{id}",method = RequestMethod.DELETE)
    public JoeJSONResult deleteNews(@PathVariable Integer id){
        //TODO 新闻图片删除
        newsService.deleteNews(id);
        return JoeJSONResult.ok("删除成功");
    }
}
