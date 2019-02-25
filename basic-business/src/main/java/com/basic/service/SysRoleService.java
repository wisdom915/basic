package com.basic.service;

import com.basic.model.SysRole;
import com.basic.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysRoleService {


    List<SysRole> selectRoleListByUserId(Long id);
}
