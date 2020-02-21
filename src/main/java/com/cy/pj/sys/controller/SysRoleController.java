package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role/")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjcets(String name,Integer pageCurrent){
       ;
        return new JsonResult( sysRoleService.findPageObjects(name,pageCurrent));
    }
    @RequestMapping("doDeleteObject")
    public JsonResult doDelteObject(Integer id){
        sysRoleService.deleteObject(id);
        return new JsonResult("删除成功");
    }

}
