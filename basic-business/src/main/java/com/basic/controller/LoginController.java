package com.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.basic.model.SysUser;
import com.basic.service.LoginService;
import com.basic.service.SysMenuService;
import com.basic.util.CaptchaUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private SysMenuService memuService;

    /**
     * 登录页
     * @return
     */
    @GetMapping(value = "/login")
    public String login(){
        Subject sub = SecurityUtils.getSubject();
        if (sub.isAuthenticated()) {
            return "/index";
        } else {
            return "/login";
        }
    }

    /**
     * 登录页
     * @return
     */
    @GetMapping(value = "/index")
    public String index(){
        Subject sub = SecurityUtils.getSubject();
        if (sub.isAuthenticated() || sub.isRemembered()) {
            return "/index";
        } else {
            return "/login";
        }
    }

    /**
     * 首页登录成功跳转
     * @return
     */
    @PostMapping(value = "/index")
    public String loginIndex(HttpServletRequest request,SysUser sysUser, Model model,Boolean rememberMe,String code){
        String sessionCode = (String)request.getSession().getAttribute("captchaCode");
        String msg = "";
        if(!sessionCode.equals(code)){
            msg = "验证码错误";
            model.addAttribute("message", msg);
            return "login";
        }
        String username = sysUser.getUsername().trim();
        String password = sysUser.getPassword().trim();
        rememberMe = rememberMe!=null?true:false;//前端记住我功能
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            if(subject.isAuthenticated()){
                /*subject.getSession().setAttribute("user",sysUser);
                JSONArray menus = memuService.menuJson();
                request.getSession().setAttribute("menus",menus);*/
                return "index";
            }
        } catch (UnknownAccountException e) {
            msg = "用户名错误";
            model.addAttribute("message", msg);
        } catch (IncorrectCredentialsException e) {
            msg = "密码错误";
            model.addAttribute("message", msg);
        } catch (Exception e){
            msg = "未知错误";
            model.addAttribute("message", msg);
        }
        return "login";
    }

    /**
     * 欢迎页
     * @return
     */
    @GetMapping(value = "/welcome")
    public String welcome(){
       return "welcome";
    }

    /**
     * 登出
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout(){
        Subject sub = SecurityUtils.getSubject();
        sub.logout();
        return "login";
    }

    /**
     * 获取图片验证码
     * @return
     */
    @GetMapping(value = "/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        CaptchaUtil.getCode(request,response);
    }
}
