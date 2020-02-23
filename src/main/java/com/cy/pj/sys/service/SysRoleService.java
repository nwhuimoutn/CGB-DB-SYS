package com.cy.pj.sys.service;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    PageObject<SysRole> findPageObjects(String name,
                                        Integer pageCurrent);
    int deleteObject(Integer id);

    int saveObject(SysRole entity,Integer[] menuIds);

    SysRoleMenuVo findObjectById(Integer id);

    int updateObject(SysRole entity,Integer[] menuIds);

    List<CheckBox> findObjects();
}
