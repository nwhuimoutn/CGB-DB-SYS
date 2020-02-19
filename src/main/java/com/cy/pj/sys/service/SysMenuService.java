package com.cy.pj.sys.service;


import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysmMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {
    int insertObject(SysmMenu entity);

    List<Node> findZtreeMenuNodes();

    int deleteObject(Integer id);
    List<Map<String,Object>> findObjects();

}
