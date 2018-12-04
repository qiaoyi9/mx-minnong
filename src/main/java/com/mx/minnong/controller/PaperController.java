package com.mx.minnong.controller;

import com.github.pagehelper.PageInfo;
import com.mx.minnong.pojo.Paper;
import com.mx.minnong.pojo.qo.PageQO;
import com.mx.minnong.service.PaperService;
import com.mx.minnong.utils.FastDFSClient;
import com.mx.minnong.utils.JoeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:22  2018/11/27
 * @Description:
 */
@RestController
@RequestMapping("/Paper/")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     * @param: id
     * 根据主键查询
     */
    @RequestMapping(value = "api/{id}" ,method = RequestMethod.GET)
    public JoeJSONResult getPaperByPrimaryKey(@PathVariable Integer id){
        Paper paper = paperService.getPaperByPrimaryKey(id);
        return JoeJSONResult.ok(paper);
    }

    /**
     * @param: id
     * 根据主键删除
     */
    @RequestMapping(value = "api/{id}" ,method = RequestMethod.DELETE)
    public JoeJSONResult deletePaperByPrimaryKey(@PathVariable Integer id){
        int reslt = paperService.deletePaperByPrimaryKey(id);
        return JoeJSONResult.ok(reslt);
    }

    /**
     * @param: Paper
     * 添加Paper
     */
    @RequestMapping(value = "api" ,method = RequestMethod.POST)
    public JoeJSONResult savePaper(Paper paper){
        int result = paperService.save(paper);
        return JoeJSONResult.ok();
    }

    /**
     * @param: Paper id
     * 根据主键修改
     */
    @RequestMapping(value = "api/{id}",method = RequestMethod.PUT)
    public JoeJSONResult updatePaperByPrimaryKey(@PathVariable Integer id,Paper paper){
        paper.setPaperId(id);
        int result = paperService.updatePaperByPrimaryKey(paper);
        return JoeJSONResult.ok(result);
    }

    @RequestMapping(value = "api",method = RequestMethod.GET)
    public JoeJSONResult findAllPaper(PageQO pageVo){
        List<Paper> papers = paperService.findAll(pageVo);
        PageInfo pageInfo = new PageInfo(papers);
        return JoeJSONResult.ok(pageInfo);
    }

    @RequestMapping(value = "file" ,method = RequestMethod.POST)
    public JoeJSONResult file(MultipartFile file) throws IOException {
        String url = fastDFSClient.uploadFile(file);
        return JoeJSONResult.ok(url);
    }
}
