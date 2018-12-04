package com.mx.minnong.pojo.qo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

/**
 * @Author: 乔一 https://www.joejay.cn
 * @Date: Created in 16:20  2018/11/27
 * @Description:
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQO<T> {

    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer pageNum = 1;

    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer pageSize = 10;

    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer topNum=10;//前多少条数据

    private String orderBy;

    private T condition;

    public int getOffset() {
        return (this.pageNum - 1) * this.pageSize;
    }

}
