package com.cy.pj.sys.service;


import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {
    int updateObject(SysMenu entity);

    int insertObject(SysMenu entity);

    List<Node> findZtreeMenuNodes();

    int deleteObject(Integer id);
    List<Map<String,Object>> findObjects();

}
