package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.SysUserDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysUserDao {
    /**
     * 禁用启用状态修改
     * @param id  用户id
     * @param valid 状态
     * @param modifiedUser 修改用户
     * @return 行数
     */
    @Update("update sys_users set valid=#{valid}, modifiedUser=#{modifiedUser}, modifiedTime=now() where id=#{id}")
    int validById(@Param("id") Integer id,
                  @Param("valid") Integer valid,
                  @Param("modifiedUser") String modifiedUser);



    int getRowCount(@Param("username") String username);

    List<SysUserDeptVo> findPageObjects(
            @Param("username")String  username,
            @Param("startIndex")Integer startIndex,
            @Param("pageSize")Integer pageSize);
}
