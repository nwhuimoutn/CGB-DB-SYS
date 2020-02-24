package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/menu/")
@RestController
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysMenu entity){
        sysMenuService.updateObject(entity);
        return new JsonResult("修改成功");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doInsertObject(SysMenu entity){
            sysMenuService.insertObject(entity);
        return new JsonResult("添加成功");
    }

    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){

        return new JsonResult(sysMenuService.findZtreeMenuNodes());
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysMenuService.deleteObject(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects(){
        List<Map<String, Object>> objects = sysMenuService.findObjects();
        return new JsonResult(objects);
    }
}
