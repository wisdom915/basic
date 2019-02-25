package com.basic.service.impl;

import com.alibaba.fastjson.JSON;
import com.basic.mapper.SysUserMapper;
import com.basic.model.SysUser;
import com.basic.service.LoginService;
import com.basic.service.SysUserService;
import com.basic.util.DataReturnUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    @Override
    public SysUser login(String username) {
        return sysUserMapper.login(username);
    }
    /**
     * 分页查询
     * @param map
     * @param page
     * @param limit
     * @return
     */
    @Override
    public String userList(Map map,Integer page, Integer limit) {
        Page<Object> pages = PageHelper.startPage(page, limit);
        List<SysUser> userList = sysUserMapper.selectUserListByMap(map);
        DataReturnUtil dataReturnUtil = new DataReturnUtil(pages.getTotal(),userList);
        return JSON.toJSONString(dataReturnUtil);
    }
}
