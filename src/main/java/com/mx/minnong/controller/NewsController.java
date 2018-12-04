package com.mx.minnong.controller;

import com.github.pagehelper.PageInfo;
import com.mx.minnong.exception.NetException;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.News;
import com.mx.minnong.pojo.qo.PageQO;
import com.mx.minnong.service.NewsService;
import com.mx.minnong.utils.ApiRootPath;
import com.mx.minnong.utils.FastDFSClient;
import com.mx.minnong.utils.FileTypeUtil;
import com.mx.minnong.utils.JoeJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     * @param: [id]
     * 查询单条新闻
     */
    @RequestMapping(value = "api/{id}", method = RequestMethod.GET)
    public JoeJSONResult findOne(@PathVariable Integer id) {
        News news = newsService.findOne(id);
        if (news != null) {
            return JoeJSONResult.ok(news);
        } else {
            return JoeJSONResult.errorMsg("没有这条新闻");
        }
    }

    /**
     * @param: [pageNum pageSize]
     * 查询多条新闻  分页查询
     */
    @RequestMapping(value = "api", method = RequestMethod.GET)
    public JoeJSONResult findAll(PageQO pageVo) {
        //TODO 新闻查询 生产环境redis缓存
        List<News> news = newsService.findAll(pageVo);
        PageInfo<News> pageInfo = new PageInfo<News>(news);
        return JoeJSONResult.ok(pageInfo);
    }

    /**
     * @param: [news]
     * 添加新闻需要权限 path > root
     */
    @RequestMapping(value = ApiRootPath.ROOTPATH + "api", method = RequestMethod.POST)
    public JoeJSONResult AddNews(News news, MultipartFile file) throws IOException {
        //TODO set 新闻发布人
        if (StringUtils.isBlank(file.getOriginalFilename())) {
            return JoeJSONResult.errorMsg("新闻头图必须上传");
        }
        //判断是否图片格式 使用fastDFS服务器存储
        if (FileTypeUtil.isImage(file.getOriginalFilename())) {
            String path = fastDFSClient.uploadFile(file);
            if (StringUtils.isNotBlank(path)) {
                news.setNewsPicture(path);
            }
        }
        newsService.saveNews(news);
        return JoeJSONResult.ok("添加成功");
    }

    /**
     * @param: [id, news]
     * 修改新闻需要权限 path > root
     */
    @RequestMapping(value = ApiRootPath.ROOTPATH + "api/{id}", method = RequestMethod.PUT)
    public JoeJSONResult updateNews(@PathVariable Integer id, News news, MultipartFile file) throws IOException {
        if (null != id && !"".equals(id)) {
            News result = newsService.findOne(id);
            //判断是否存在这条新闻
            if (result != null) {
                news.setNewsId(id);
                //设置修改时间
                news.setNewsUpdatetime(new Date());
                //判断是否上传图片
                if (StringUtils.isNotBlank(file.getOriginalFilename())) {
                    //判断数据库是否已经存在图片
                    if (StringUtils.isNotBlank(result.getNewsPicture())) {
                        fastDFSClient.deleteFile(result.getNewsPicture());
                    }
                    news.setNewsPicture(fastDFSClient.uploadFile(file));
                }
                int i = newsService.updateNews(news);
                return JoeJSONResult.ok("修改成功");
            } else {
                return JoeJSONResult.errorMsg("新闻不存在");
            }
        } else {
            log.error("【修改新闻】 id参数为空 news={}", news);
            throw new NetException(NetEnum.ID_ISEMPTY);
        }
    }

    /**
     * @param: [id]
     * 删除新闻 如果新闻存在图片删除图片
     */
    @RequestMapping(value = ApiRootPath.ROOTPATH + "api/{id}", method = RequestMethod.DELETE)
    public JoeJSONResult deleteNews(@PathVariable Integer id) {
        News news = newsService.findOne(id);
        if (news != null) {
            //判断新闻是否存在图片  如果存在图片 则删除
            if (StringUtils.isNotEmpty(news.getNewsPicture())) {
                fastDFSClient.deleteFile(news.getNewsPicture());
            }
            newsService.deleteNews(id);
        } else {
            return JoeJSONResult.errorMsg("新闻不存在");
        }
        return JoeJSONResult.ok("删除成功");
    }
}
