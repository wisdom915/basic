package com.basic.controller;

import com.basic.service.SysMenuService;
import com.basic.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {


    @Autowired
    private SysUserService userService;

    /**
     * 用户页面
     * @return
     */
    @RequiresPermissions("user:show")
    @GetMapping(value = "/index")
    public String index(){
        return "user/user-list";
    }

    /**
     * 用户列表
     * @return
     */
//    @RequiresPermissions("user:show")
    @GetMapping(value = "/userList")
    @ResponseBody
    public String userList(@RequestParam Map map, Integer page, Integer limit){
        String jsonStr = userService.userList(map,page,limit);
        return jsonStr;
    }


}
