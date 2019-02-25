package com.basic.mapper;

import com.basic.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    SysUser login(String username);

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<SysUser> selectUserListByMap(Map map);
}