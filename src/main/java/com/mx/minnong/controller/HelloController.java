package com.mx.minnong.controller;

import com.mx.minnong.utils.FastDFSClient;
import com.mx.minnong.utils.FileTypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 21:36  2018/11/16
 * @Description:
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    FastDFSClient fastDFSClient;


    @GetMapping("/hello")
    public String hello(MultipartFile file) throws IOException {
        System.out.println(file.getSize());

        String filename = file.getOriginalFilename();
        boolean b = FileTypeUtil.isImage(filename);
        if (b){
            String url = fastDFSClient.uploadFile(file);
            return url;
        }else {
            return "图片格式不对";
        }

    }

    @GetMapping("/test")
    public String test(){
        return "Joe";
    }
}
