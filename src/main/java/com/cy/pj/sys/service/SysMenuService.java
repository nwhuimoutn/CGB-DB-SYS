package com.cy.pj.sys.service;


import java.util.List;
import java.util.Map;

public interface SysMenuService {

    int deleteObject(Integer id);
    List<Map<String,Object>> findObjects();

}
