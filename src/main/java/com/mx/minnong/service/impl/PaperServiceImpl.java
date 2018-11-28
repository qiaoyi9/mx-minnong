package com.mx.minnong.service.impl;

import com.github.pagehelper.PageHelper;
import com.mx.minnong.exception.NetException;
import com.mx.minnong.mapper.PaperMapper;
import com.mx.minnong.myenum.NetEnum;
import com.mx.minnong.pojo.Paper;
import com.mx.minnong.pojo.vo.PageVo;
import com.mx.minnong.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 15:26  2018/11/27
 * @Description:
 */
@Service
@Slf4j
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public Paper getPaperByPrimaryKey(Integer id) {
        if ("".equals(id) && null == id){
            log.info("【学术论文】 getPaperByPrimaryKey  id is empty");
            throw new NetException(NetEnum.ID_ISEMPTY);
        }else {
            return paperMapper.selectByPrimaryKey(id);
        }
    }

    @Override
    @Transactional
    public int deletePaperByPrimaryKey(Integer id) {
        if ("".equals(id) && null == id){
            log.info("【学术论文】 getPaperByPrimaryKey  id is empty");
            throw new NetException(NetEnum.ID_ISEMPTY);
        }else {
            return paperMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    @Transactional
    public int save(Paper paper) {
        return paperMapper.insertSelective(paper);
    }

    @Override
    @Transactional
    public int updatePaperByPrimaryKey(Paper paper) {
        return paperMapper.updateByPrimaryKeySelective(paper);
    }

    @Override
    public List<Paper> findAll(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        return paperMapper.selectAll();
    }
}
