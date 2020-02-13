package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/log/")
public class SysLogController {
    @Autowired
    SysLogService sysLogService;

    @ResponseBody //转化为字符串
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username,Integer pageCurrent){
        PageObject<SysLog> pageObject = sysLogService.findPageObject(username, pageCurrent);
        JsonResult jsonResult = new JsonResult(pageObject);

        return jsonResult;
    }
//    异常处理类  优先局部异常  在全局异常调用
//    @ResponseBody
//    @ExceptionHandler(RuntimeException.class)
//    public JsonResult doGlobalExceptionHandler(RuntimeException e){
//        e.printStackTrace();
//        return new JsonResult(e);
//    }
   //根据id删除
    @ResponseBody
    @RequestMapping("doDeleteObjects")
    public JsonResult doDeleteObjects(Integer... ids){
        int rows = sysLogService.deleteObjects(ids);
        return new JsonResult("删除成功");
    }

}
