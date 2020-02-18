package com.cy.pj.sys.service.Impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuDao sysMenuDao;
    @Autowired
    SysRoleMenuDao sysRoleMenuDao;


    @Override
    public int deleteObject(Integer id) {
        //1.验证数据的合法性
        if(id==null||id<=0)
            throw new IllegalArgumentException("请先选择");
        //2.基于id进行子元素查询
        int count=sysMenuDao.getChildCount(id);
        if(count>0)
            throw new ServiceException("请先删除子菜单");
        //3.删除角色,菜单关系数据
        sysRoleMenuDao.deleteRoleMenuObjects(id);
        //4.删除菜单元素
        int rows=sysMenuDao.deleteObject(id);
        if(rows==0)
            throw new ServiceException("此菜单可能已经不存在");
        //5.返回结果
        return rows;
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        List<Map<String, Object>> objects = sysMenuDao.findObjects();
        if (objects==null&&objects.size()==0)
            throw new SecurityException("页面错误");
        return objects;
    }
}
