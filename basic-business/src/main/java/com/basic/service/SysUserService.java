package com.basic.service;

import com.basic.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface SysUserService {

    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    public SysUser login(String username);

    /**
     * 分页查询
     * @param map
     * @param page
     * @param limit
     * @return
     */
    String userList(Map map,Integer page, Integer limit);
}
