package com.cy.pj.sys;

import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    SysUserDao sysUserDao;

    @Test
    public void userTest(){
        int rowCount = sysUserDao.getRowCount("wumei");
        System.out.println(rowCount);

    }
    @Test
    public  void userTest2(){
        List<SysUserDeptVo> user = sysUserDao.findPageObjects("user-a", 0, 5);

        user.forEach((a)-> System.out.println(a));
    }
}
