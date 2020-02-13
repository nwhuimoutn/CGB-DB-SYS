package com.cy.pj.sys.entity;


import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;   //用户名
    private String operation; //用户操作
    private String method;    //请求方法
    private String params;     //请求参数
    private Long time;     //请求执行时间
    private String ip;        //请求ip地址
    private Date createdTime; //创建时间



    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getOperation() {
        return operation;
    }

    public String getMethod() {
        return method;
    }

    public String getParams() {
        return params;
    }

    public Long getTime() {
        return time;
    }

    public String getIp() {
        return ip;
    }

    public Date getCreatedTime() {
        return createdTime;
    }
}
