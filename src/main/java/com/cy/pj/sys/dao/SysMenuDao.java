package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysmMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuDao {
     /**
      * 插入子表字段
      * @return
      */

       int insertObject(SysmMenu entity);

     /**
      *  查询上级菜单相关信息
      * @return
      */
     List<Node> findZtreeMenuNodes();
     /**
      * 查询子菜单id
      * @param id
      * @return
      */
     @Select("select count(*) from sys_menus where parentId=#{id}")
     int getChildCount(Integer id);

     /**
      * 基于id删除
      * @param id
      * @return
      */
     @Delete("delete from sys_menus where id=#{id} ")
     int deleteObject(Integer id);
     /**
      * 查询上级菜单以及对应的上级菜单名称
      * 一行记录映射为一个map对象(key为字段名明,v每行对应记录)
      * @return
      */
     List<Map<String,Object>> findObjects();
}
