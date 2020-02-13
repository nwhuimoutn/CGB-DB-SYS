package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/")
@Controller
public class PageController {
    //AtomicLong 线程安全 基于CSA算法  对原子性的操作
    AtomicLong al=new AtomicLong(0);

    //访问后台页面
    @RequestMapping("doStarterUI")
    public String doStarterUI(){
        // al.incrementAndGet() 递增
        //实现访问次数的记录
        System.out.println( "访问次数="+ al.incrementAndGet());
        return "starter";
    }
    //访问日志管理模块
    @RequestMapping("log/log_list")
    public String doLogUI() {
        return "sys/log_list";
    }
    //分页
    @RequestMapping("doPageUI")
    public String doPageUI() {
        return "common/page";
    }



}
