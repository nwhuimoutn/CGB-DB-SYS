package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysUserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
