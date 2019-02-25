package com.basic.core;

import com.basic.model.SysUser;
import com.basic.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @date 2017/12/11.
 * 自定义shiro拦截器 校验用户是否已授权 未授权返回到登录界面
 */
@Slf4j
public class PermissionFilter extends AuthorizationFilter {

  @Autowired
  private SysUserService userService;


  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,Object o) throws Exception {
    System.out.println("---------校验用户是否已授权");
   /* Subject sub = getSubject(request, response);
    Session session= sub.getSession();
    SysUser user= (SysUser) session.getAttribute("sysUser");
    if(user==null) {
      return false;
    }*/
    return true;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)throws IOException {
      try{
        saveRequest(request);
        WebUtils.issueRedirect(request, response, "/login");
        return true;
      }catch (Exception e){
        return false;
      }
  }
}
