package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuDao {
     /**
      * 查询上级菜单以及对应的上级菜单名称
      * 一行记录映射为一个map对象(key为字段名明,v每行对应记录)
      * @return
      */
     List<Map<String,Object>> findObjects();
}
