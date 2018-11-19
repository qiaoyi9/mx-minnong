package com.mx.minnong.utils;

import com.mx.minnong.exception.NetException;
import com.mx.minnong.myenum.NetEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 10:36  2018/11/19
 * @Description: 文件上传 格式处理类
 */
@Slf4j
public class FileTypeUtil {

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 10:46 2018/11/19
     * @param: [fileName]
     * @return: java.lang.String
     * @methodName: getFileType
     * @Description:  获取文件的格式
     */
    public static String getFileType(String fileName) {
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length -1;
        //System.out.println(strArray[suffixIndex]);
        return strArray[suffixIndex];
    }

    /**
     * @auther: 乔一 https://www.joejay.cn
     * @date: 10:47 2018/11/19
     * @param: [type]
     * @return: boolean
     * @methodName: isImage
     * @Description: 判断文件是否为图片 是 返回true  不是 返回false
     */
    public static boolean isImage(String fileName){
        if (StringUtils.isEmpty(fileName)){
            log.info("【上传文件】 文件名不能为空");
            throw new NetException(NetEnum.FILENAME_ISEMPTY);
        }
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length -1;
        String fileType = strArray[suffixIndex];
        switch (fileType){
            case "JPG":
                return true;
            case "jpg":
                return true;
            case "JPEG":
                return true;
            case "jpeg":
                return true;
            case "png":
                return true;
            case "PNG":
                return true;
            case "gif":
                return true;
             default: return false;
        }
       /* if (fileType.equals("JPG")){
            return true;
        }else if (fileType.equals("JPEG")){
            return true;
        }else if (fileType.equals("jpg")){
            return true;
        }else if (fileType.equals("PNG")){
            return true;
        }else if (fileType.equals("png")){
            return true;
        }else if (fileType.equals("gif")){
            return true;
        }else if (fileType.equals("jpeg")){
            return true;
        }else {
            return false;
        }*/
    }

}
