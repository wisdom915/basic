package com.basic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.basic.mapper.SysMenuMapper;
import com.basic.model.SysMenu;
import com.basic.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 查询菜单
     * @return
     */
    @Override
    public JSONArray menuJson() {
        JSONArray jsonArray = new JSONArray();
        List<SysMenu> menuList = sysMenuMapper.selectMenuList();
        for(SysMenu menu:menuList){
            if (menu.getParentId()==0) {
                SysMenu sysMenu = getChild(menu, menuList);
                jsonArray.add(sysMenu);
            }
        }
        return jsonArray;
    }

    @Override
    public List<SysMenu> getUserMenuByUserId(Long id) {
        return sysMenuMapper.selectUserMenuByUserId(id);
    }

    @Override
    public JSONArray getJsonMenu(List<SysMenu> menuList) {
        JSONArray jsonArray = new JSONArray();
        for(SysMenu menu:menuList){
            if (menu.getParentId()==0) {
                SysMenu sysMenu = getChild(menu, menuList);
                jsonArray.add(sysMenu);
            }
        }
        return jsonArray;
    }

    private SysMenu getChild(SysMenu sysMenu,List<SysMenu> menuList){
        for(SysMenu menu:menuList){
            if (sysMenu.getId() == menu.getParentId()) {
                SysMenu child = getChild(menu, menuList);
                sysMenu.addChild(child);
            }
        }
        return sysMenu;


    }
}

