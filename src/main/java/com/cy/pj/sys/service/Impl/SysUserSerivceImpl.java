package com.cy.pj.sys.service.Impl;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserSerivce;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SysUserSerivceImpl implements SysUserSerivce {
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SysUserRoleDao sysUserRoleDao;
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
    //添加
    @Override
    public int saveObject(SysUser entity, Integer[] roleIds) {
        //1参数校验
        if(entity==null) throw  new ServiceException("保存对象不能为空");
     //   if (entity.getUsername().equals(entity.getUsername()))throw  new ServiceException("用户名重复");
        if(roleIds==null||roleIds.length==0) throw new ServiceException("对象不能为空");
        if(StringUtils.isEmpty(entity.getUsername())) throw new ServiceException("用户名不能为空");
        if(StringUtils.isEmpty(entity.getPassword()))throw  new ServiceException("密码不能为空");
        //2保存自身
         //2.1加密保存
         String source= entity.getPassword();
         String salt= UUID.randomUUID().toString();
         //shiro框架
        SimpleHash sh=new SimpleHash("" +
                "MD5"//加密算法
                ,source,//原密码
                salt,//盐值
                1);//加密次数
        entity.setSalt(salt);  //加盐
        entity.setPassword(sh.toHex());//密码转为16进制
        //2.2持久化用户信息
        int rows = sysUserDao.insertObject(entity);
        //2.3保存角色关系数据
        sysUserRoleDao.insertObjects(entity.getId(), roleIds);
        return rows;
    }

    @Override
    public Map<String, Object> findObjectById(Integer userId) {
        //1.验证数据合法性
        if(userId==null||userId==0)throw new ServiceException("数据不正确");
        //2.业务查询
        SysUserDeptVo user= sysUserDao.findObjectById(userId);
        if(user==null)throw new ServiceException("用户不存在");
        List<Integer> roleIdsByUserId = sysUserRoleDao.findRoleIdsByUserId(userId);
        //3.数据封装
        Map<String,Object> map=new HashMap<>();
        map.put("user",user);
        map.put("userIds",userId);
        return map;
    }

    @Override
    public int updateObject(SysUser entity, Integer[] roleIds) {
        //验证数据合法性
        if(entity==null) throw new  ServiceException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getUsername())) throw new ServiceException("用户名不能为空");
//        if(StringUtils.isEmpty(entity.getPassword())) throw new ServiceException("密码不能为空");
        if(roleIds==null||roleIds.length==0) throw new ServiceException("请指定角色");

        //2.更新用户自身信息
        int row = sysUserDao.updateObject(entity);
        //删除原来的关系数据
        sysUserRoleDao.deleteObjectByRoleId(entity.getId());
        //保存关系数据
        sysUserRoleDao.insertObjects(entity.getId(),roleIds);

        return row;
    }
}
