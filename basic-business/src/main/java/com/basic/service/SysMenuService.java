package com.basic.service;

import com.alibaba.fastjson.JSONArray;
import com.basic.model.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysMenuService {

    JSONArray menuJson();

    List<SysMenu> getUserMenuByUserId(Long id);

    JSONArray getJsonMenu(List<SysMenu> menuList);
}
