package com.cy.pj.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {

    private Integer pageCurrent=1;//当前页码值
    private Integer pageSize=3;   //页面显示几条记录
    private Integer rowCount=0;   //总行数(通过查询获得)
    private Integer pageCount=0;  //总页数(通过计算获得)
    private List<T> records;      //记录页数

    public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
        this.records = records;

        this.pageCount=(rowCount-1)/pageSize+1;//计算总页数
    }
}
