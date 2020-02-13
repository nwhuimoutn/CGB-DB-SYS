package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogDao {

    /**
     * 基于查询条件总记录数
     * @param username 查询条件(例如查询哪个用户的日志信息)
     * @return 总记录数(基于这个结果可以及时总页数)
     *
     */
    //统计记录总数
   int getRowCount(@Param("username") String username);//基于名字
  //分页查询
    //基于条件查询当前页呈现的数据
   List<SysLog> findLogObject(
           @Param("username") String username, //基于名字查询
           @Param("startIndex") Integer startIndex,//起始位置
           @Param("pageSize") Integer pageSize); //查询条数


    /**
     * 根据id删除数据
     * @param ids
     * @return
     */
    int  deleteObjects(
                @Param("ids") Integer ... ids);
}
