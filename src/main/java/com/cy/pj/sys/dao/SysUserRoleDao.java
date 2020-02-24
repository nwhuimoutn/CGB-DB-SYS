package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserRoleDao {
    /**
     * 删除关联id 用户与角色关联id
     * @param id
     * @return
     */
    @Delete("delete from sys_user_roles where role_id=#{id}")
     int deleteObjectByRoleId(Integer id);

    /**
     * 用户角色关系数据
     * @param userId
     * @param roleIds
     * @return
     */

    int insertObjects(@Param("userId") Integer userId,
                      @Param("roleIds")Integer[] roleIds);

    List<Integer> findRoleIdsByUserId(Integer id);

    /**
     * 基于用户id删除关系数据
     * @param id
     * @return
     */
    @Delete("update from sys_user_roles where user_id=#{id}")
    int updateObjectByRoleId(Integer id);

}





