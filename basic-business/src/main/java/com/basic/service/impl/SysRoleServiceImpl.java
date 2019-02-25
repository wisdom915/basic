package com.basic.service.impl;

import com.basic.mapper.SysRoleMapper;
import com.basic.mapper.SysUserMapper;
import com.basic.model.SysRole;
import com.basic.model.SysUser;
import com.basic.service.SysRoleService;
import com.basic.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public List<SysRole> selectRoleListByUserId(Long userId) {
        return sysRoleMapper.selectRoleListByUserId(userId);
    }
}
