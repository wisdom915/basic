package com.basic.core;

import com.alibaba.fastjson.JSONArray;
import com.basic.model.SysMenu;
import com.basic.model.SysRole;
import com.basic.model.SysUser;
import com.basic.service.SysMenuService;
import com.basic.service.SysRoleService;
import com.basic.service.SysUserService;
import com.basic.vo.CurrentUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * @date 2017/12/4.
 */
@Component
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private SysUserService sysUserService;
    @Autowired
    @Lazy
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 权限授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        CurrentUser currentUser = (CurrentUser)principalCollection.getPrimaryPrincipal();
        CurrentUser currentUser = (CurrentUser)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        for(SysRole role:currentUser.getRoleList()){
            info.addRole(role.getId().toString());
        }
        for(SysMenu menu:currentUser.getMenuList()){
            if(!StringUtils.isEmpty(menu.getPermission())){
                info.addStringPermission(menu.getPermission());
            }
        }
        return info;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        SysUser user = null;
        try {
            user = sysUserService.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UnknownAccountException("账户密码不正确");
        }
        CurrentUser currentUser = new CurrentUser();//当前用户
        List<SysRole> roleList = sysRoleService.selectRoleListByUserId(user.getId());
        if(roleList==null || roleList.size()==0){
            throw new DisabledAccountException("用户没有可用角色");
        }else{
            List<SysMenu> currentMenuList=new ArrayList<>();//当前用户所有菜单按钮列表
            List<SysRole> currentRoleList=new ArrayList<>();//当前用户所有角色列表
            currentUser.setUser(user);
            List<SysMenu> menuList=new ArrayList<>(new HashSet<>(sysMenuService.getUserMenuByUserId(user.getId())));
            JSONArray jsonMenu = sysMenuService.getJsonMenu(menuList);
            for(SysMenu menu:menuList){
                SysMenu sysMenu = new SysMenu(menu.getId(),menu.getParentId(),menu.getName(),menu.getUrl(),menu.getPermission(),menu.getType(),menu.getIcon(),menu.getOrderNum());
                currentMenuList.add(sysMenu);
                currentRoleList.addAll(menu.getRoleList());
            }
            currentUser.setMenuList(currentMenuList);
            currentRoleList=new ArrayList<>(new HashSet<>(currentRoleList));
            currentUser.setRoleList(currentRoleList);
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute("menus",jsonMenu);
            session.setAttribute("currentUser",currentUser);
        }

        ByteSource byteSource = ByteSource.Util.bytes(username);
        return new SimpleAuthenticationInfo(username, user.getPassword(), byteSource, getName());
    }

}
