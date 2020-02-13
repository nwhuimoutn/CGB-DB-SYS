package com.cy.pj.sys.service.Impl;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.PageUtil;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
     private SysLogDao sysLogDao;
    //配置数据注入
    @Autowired
    PageProperties pageProperties;
//    @Value("3")
//    int pageSize;
    @Override
    public PageObject<SysLog> findPageObject(String username, Integer pageCurrent) {
        //1.参数校验
        //1.1验证pageCurrent  调用的配置类方法
        //spring提供了一个配置方法类 Assert
        PageUtil.isValid(pageCurrent);
//        Assert.isTrue(pageCurrent==null&&pageCurrent>=1,
//                "页面错误");
        //2.查询总记录数并校验
        //2.1查询记录
        int rowCount = sysLogDao.getRowCount(username);
        //2.2判断查询结果ServiceException 自己定义异常
        if (rowCount==0)throw  new ServiceException("无对应记录");
        //3.查询当前页面日志记录
//        int pageSize=3;
        int pageSize=pageProperties.getPageSize();
        //计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //把对象,起始页面,页数封装给recirds
        List<SysLog> records = sysLogDao.findLogObject(username,startIndex, pageSize);
        //4.封装结果并返回
        PageObject<SysLog> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(records);
        pageObject.setPageCount((rowCount-1)/pageSize+1);
        return pageObject;

    }

    @Override
    public int deleteObjects(Integer... ids) {
        //1.判定参数合法性
        if(ids==null||ids.length==0)
            throw  new IllegalArgumentException("请选择");
//        Assert.isTrue(ids==null||ids.length==0,"请选择");
        //2执行删除操作
        int rows;
        try {
            rows=sysLogDao.deleteObjects(ids);
        }catch (Throwable e){
            e.printStackTrace();
            //3发出报警信息
            throw  new ServiceException("系统故障");
        }
        if(rows==0){
            throw new ServiceException("记录不存在");

        }
        //返回结果
        return rows;
    }


}

