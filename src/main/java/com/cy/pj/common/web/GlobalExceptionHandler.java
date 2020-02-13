package com.cy.pj.common.web;

import com.cy.pj.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ControllerAdvice 注解描述的类为全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * @ExceptionHandler(RuntimeException.class) 描述的类为异常处理类
     * @return
     */
      @ResponseBody
      @ExceptionHandler(RuntimeException.class)
      public JsonResult doGlobalExceptionHandler(RuntimeException e){
          e.printStackTrace();
          return new JsonResult(e);
      }
}
