package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
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

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects(){
        List<Map<String, Object>> objects = sysMenuService.findObjects();
        return new JsonResult(objects);
    }
}
