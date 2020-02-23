package com.cy.pj.sys.service.Impl;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.service.SysUserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserSerivceImpl implements SysUserSerivce {
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    PageProperties pageProperties;

    @Override
    public int vaildById(Integer id, Integer valid, String modifiedUser) {
        //验证合法性
        if(id==null||id<0)throw  new ServiceException("id错误");
        System.out.println("id"+id);
        if(valid!=1&&valid!=0) throw  new ServiceException("状态错误");
        System.out.println("valid="+valid);
//        if(StringUtils.isEmpty(modfiedUser))throw  new ServiceException("修改用户不能为空");
        System.out.println("modfiedUser="+modifiedUser);
        int row = sysUserDao.validById(id, valid, modifiedUser);
        if(row==0)throw  new ServiceException("记录不存在");
        System.out.println("row="+row);
        return row;
    }

    @Override
    public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {

        //1.验证参数有效性
        PageUtil.isValid(pageCurrent);
        //2.查询总记录数
        int rowCount=sysUserDao.getRowCount(username);
        if(rowCount==0) throw new ServiceException("没有对应的记录");
        //3查询当前页记录
        int pageSize=pageProperties.getPageSize();
        int startIndex=(pageCurrent-1)*pageSize;

        List<SysUserDeptVo> records = sysUserDao.findPageObjects(username, startIndex, pageSize);

        //4.对查询结果进行封装并返回
        return new PageObject<>(pageCurrent,pageSize,rowCount,records);
    }
}
