package com.mx.minnong.service;
/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:26  2018/11/27
 * @Description:
 */

import com.mx.minnong.pojo.Paper;
import com.mx.minnong.pojo.vo.PageVo;

import java.util.List;


/**
 * @Author: 乔一
 * @createtime 2018-11-27 15:26
 **/
public interface PaperService {

    Paper getPaperByPrimaryKey(Integer id);

    int deletePaperByPrimaryKey(Integer id);

    int save(Paper paper);

    int updatePaperByPrimaryKey(Paper paper);

    List<Paper> findAll(PageVo pageVo);
}
