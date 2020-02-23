package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;

public interface SysUserSerivce {

    //修改禁用状态
    int vaildById(Integer id,Integer valid,String modifiedUser);
    //查询
    PageObject<SysUserDeptVo> findPageObjects(String username,Integer pageCurrent);
}
