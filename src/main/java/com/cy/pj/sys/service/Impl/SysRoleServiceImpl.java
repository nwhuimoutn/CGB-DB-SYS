package com.cy.pj.sys.service.Impl;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private PageProperties pageProperties;
    @Override
    public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
        //1.验证参数有效性
        PageUtil.isValid(pageCurrent);
        //2.查询总记录数
        int rowCount=sysRoleDao.getRowCount(name);
        if(rowCount==0) throw new ServiceException("没有对应的记录");
        //3查询当前页记录
        int pageSize=pageProperties.getPageSize();
        int startIndex=(pageCurrent-1)*pageSize;

        List<SysRole> records = sysRoleDao.findPageObject(name, startIndex, pageCurrent);
        //4.对查询结果进行封装并返回
        return new PageObject<>(pageCurrent,pageSize, rowCount,records);
    }

    @Override
    public int deleteObject(Integer id) {
        //先校验id
        if (id==null&&id>0) throw new ServiceException("不能为空");
        //删除菜单id
        sysRoleMenuDao.deleteObjectsByRoleId(id);
        //删除用户id
        sysUserRoleDao.deleteObjectByRoleId(id);
        //删除角色id
        int row = sysRoleDao.deleteObject(id);
        if(row==0)throw new ServiceException("删除记录不存在");
        return row;
    }
}
