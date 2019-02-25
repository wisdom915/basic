package com.basic.mapper;

import com.basic.model.sysRoleMenu;

public interface sysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(sysRoleMenu record);

    int insertSelective(sysRoleMenu record);

    sysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(sysRoleMenu record);

    int updateByPrimaryKey(sysRoleMenu record);
}