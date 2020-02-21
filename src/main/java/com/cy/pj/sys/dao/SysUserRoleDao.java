package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleDao {
    /**
     * 删除关联id 用户与角色关联id
     * @param id
     * @return
     */
    @Delete("delete from sys_user_roles where role_id=#{id}")
     int deleteObjectByRoleId(Integer id);
}
