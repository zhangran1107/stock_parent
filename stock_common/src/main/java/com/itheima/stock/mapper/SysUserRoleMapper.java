package com.itheima.stock.mapper;

import com.itheima.stock.pojo.entity.SysUserRole;

/**
 * @Entity com.itheima.stock.pojo.entity.SysUserRole
 */
public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

}
