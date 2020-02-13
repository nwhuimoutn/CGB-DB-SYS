package com.cy.pj.common.util;

public class PageUtil {
    //配置状态判定的配置方法
    public static void isValid(Integer pageCurrent){
        if (pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("页面不存在");
    }
}
