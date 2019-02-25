package com.basic.controller;

import com.basic.service.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "menu")
public class MenuController {


    @Autowired
    private SysMenuService memuService;

    /**
     * 登录页
     * @return
     */
    @RequiresPermissions("menu:show")
    @GetMapping(value = "/index")
    public String index(){
        return "menu/menu-list";
    }




}
