package com.cy.pj.sys;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class servicePageTest {
    @Autowired
    SysLogService sysLogService;
    @Test
    public void PageTest(){
        PageObject<SysLog> admin = sysLogService.findPageObject("admin", 3);
        System.out.println(admin);
    }
}
