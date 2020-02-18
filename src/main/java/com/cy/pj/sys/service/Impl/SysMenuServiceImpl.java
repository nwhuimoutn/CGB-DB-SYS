package com.cy.pj.sys.service.Impl;

import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuDao sysMenuDao;


    @Override
    public List<Map<String, Object>> findObjects() {
        List<Map<String, Object>> objects = sysMenuDao.findObjects();
        if (objects==null&&objects.size()==0)
            throw new SecurityException("页面错误");
        return objects;
    }
}
