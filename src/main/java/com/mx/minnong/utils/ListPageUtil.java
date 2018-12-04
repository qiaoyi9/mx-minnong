package com.mx.minnong.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author: zhl
 * @Date: Createdtime 2018/12/3 16:43
 * @Description list集合分页
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class ListPageUtil<T> {
    /**原集合*/
    private List<T> data;

    /** 上一页 */
    private int prePage;

    /** 当前页 */
    @Range(min = 1)
    private int pageNum=1;

    /** 下一页 */
    private int nextPage;
    //
    /** 每页条数 */
    @Range(min = 1)
    private int pageSize=10;

    /** 总页数 */
    private int pages;

    /** 总数据条数 */
    private int total;

    public ListPageUtil(List<T> data,int pageNum,int pageSize) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("data must be not empty!");
        }

        this.data = data;
        this.pageSize = pageSize;
	        /*this.pages = data.size()/pageSize;
	        if(data.size()%pageSize!=0){
	            this.pages++;
	        }*/

        this.pageNum = pageNum;
        this.total = data.size();
        this.pages = (total + pageSize - 1) / pageSize;
        this.prePage = pageNum-1>1? pageNum-1:1;
        this.nextPage = pageNum>=pages? pages: pageNum + 1;

    }

    /**
     * 得到分页后的数据
     *
     * @param pageNum 页码
     * @return 分页后结果
     */
    public List<T> getPagedList() {
        int fromIndex = (pageNum - 1) * pageSize;
        if (fromIndex >= data.size()) {
            return Collections.emptyList();//空数组
        }
        if(fromIndex<0){
            return Collections.emptyList();//空数组
        }
        int toIndex = pageNum * pageSize;
        if (toIndex >= data.size()) {
            toIndex = data.size();
        }
        return data.subList(fromIndex, toIndex);
    }
}
