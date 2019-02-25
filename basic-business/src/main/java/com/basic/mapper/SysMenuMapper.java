package com.basic.mapper;

import com.basic.model.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    /**
     * 查询菜单
     * @return
     */
    List<SysMenu> selectMenuList();

    List<SysMenu> selectChildrenList(Long id);

    List<SysMenu> selectUserMenuByUserId(Long id);
}