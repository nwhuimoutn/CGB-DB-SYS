package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.entity.SysUser;

import java.util.Map;

public interface SysUserSerivce {

    //修改禁用状态
    int vaildById(Integer id,Integer valid,String modifiedUser);
    //查询
    PageObject<SysUserDeptVo> findPageObjects(String username,Integer pageCurrent);

    //添加
    int saveObject(SysUser entity,Integer[] roleIds);

    //用于获取用户数据     后修改
    Map<String,Object> findObjectById(Integer userId);
    //修改
    int updateObject(SysUser entity ,Integer[] roleIds);
}
