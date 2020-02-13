package com.cy.pj.sys.log;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LogDaoTest {
    @Autowired
    SysLogDao sysLogDao;
    @Test
    public void sysLogDaoTest(){
        int rowCount = sysLogDao.getRowCount("admin");
        System.out.println(rowCount);
    }
    @Test
    public void findLogObjectTest(){
        List<SysLog> admin = sysLogDao.findLogObject("admin", 0, 5);
        admin.forEach((a-> System.out.println(a)));
    }

}
