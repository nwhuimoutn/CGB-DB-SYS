package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleDao {
     int getRowCount(
             @Param("name") String name);

     List<SysRole> findPageObject(
             @Param("name")String name,
             @Param("startIndex") Integer startIndex,
             @Param("pageSize") Integer pageSize);

     @Delete("delete from sys_roles where id=#{id}")
     int deleteObject(Integer id);

     int insertObject(SysRole entity);

     SysRoleMenuVo findObjectById(@Param("id") Integer id);

     int updateObject(SysRole entity);

     /**
      * 用于添加user   vo对象
      * 先查询角色
      * @param
      * @return
      */
     @Select("select id,name from sys_roles")
     List<CheckBox> findObjects();
}
