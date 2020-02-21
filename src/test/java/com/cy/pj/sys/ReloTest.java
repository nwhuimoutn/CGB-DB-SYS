package com.cy.pj.sys;

import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.entity.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ReloTest {
    @Autowired
    SysRoleDao sysRoleDao;
    @Test
    public void  reloTest(){

        int rowCount = sysRoleDao.getRowCount("运维");
        System.out.println("人数:"+rowCount);
      log.info("运维人数{}",rowCount);
    }
    @Test
    public void  reloObjcet(){
        List<SysRole> page = sysRoleDao.findPageObject("运维", 0, 5);
        page.forEach((a)->log.info(a.toString()));

    }
}
