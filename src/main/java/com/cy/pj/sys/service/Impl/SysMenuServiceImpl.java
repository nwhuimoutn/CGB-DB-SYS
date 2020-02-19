package com.cy.pj.sys.service.Impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysmMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuDao sysMenuDao;
    @Autowired
    SysRoleMenuDao sysRoleMenuDao;


    //添加
    @Override
    public int insertObject(SysmMenu entity) {
        //1.参数校验
        if(entity==null)throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
        throw new IllegalArgumentException("菜单名不能为空");
        int rows;
        //2.保存数据
        try{
            rows=sysMenuDao.insertObject(entity);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServiceException("保存失败");
        }
        return rows;
       
    }
    //查询上级菜单
    @Override
    public List<Node> findZtreeMenuNodes() {
        List<Node> ztreeMenuNodes = sysMenuDao.findZtreeMenuNodes();
        return ztreeMenuNodes;
    }

    @Override
    public int deleteObject(Integer id) {
        //1.验证数据的合法性
        Assert.isTrue(id!=0,"数据错误");
//        if(id==null||id<=0)
//            throw new IllegalArgumentException("请先选择");
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
