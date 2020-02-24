package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    SysUserSerivce sysUserSerivce;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username,Integer pageCurrent){
        return new JsonResult( sysUserSerivce.findPageObjects(username,pageCurrent));
    }
    @RequestMapping("doValidById")
    public JsonResult doVaildById(Integer id,Integer valid,String modifiedUser){
        sysUserSerivce.vaildById(id,valid,modifiedUser);
        return new JsonResult("修改成功");
    }
    @RequestMapping("doSaveObject")
    public  JsonResult doSaveObject(SysUser entity,Integer[] roleIds){
    sysUserSerivce.saveObject(entity,roleIds);
        return new JsonResult("添加成功");
    }
    @RequestMapping("doFindObjectById")
    public  JsonResult doFindObjectById(Integer id){
        Map<String, Object> map = sysUserSerivce.findObjectById(id);
        return new JsonResult(map);
    }
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysUser entity,Integer[] roleIds ){
        sysUserSerivce.updateObject(entity,roleIds);
        return new JsonResult("修改成功");
    }
}
