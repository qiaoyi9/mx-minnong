package com.mx.minnong.mapper;

import com.mx.minnong.pojo.Kind;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 14:49  2018/11/20
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class KindMapperTest {

    @Autowired
    private KindMapper kindMapper;

    @Test
    public void findAllByKindFid() {
        List<Kind> kinds = kindMapper.findAllByKindFid(1);
        System.out.println(kinds.size());
        for (Kind obj: kinds) {if (obj!=null){
            System.out.println(obj.toString());
        }

        }
    }
}