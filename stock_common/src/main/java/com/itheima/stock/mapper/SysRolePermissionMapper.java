package com.itheima.stock.mapper;

import com.itheima.stock.pojo.entity.SysRolePermission;

/**
 * @Entity com.itheima.stock.pojo.entity.SysRolePermission
 */
public interface SysRolePermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

}
