package com.basic.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;

/**
 * @date 2018/1/16.
 * freemarker 使用shiro标签
 */
@Component
public class FreemarkerShiroConfig {

  @Autowired
  private FreeMarkerConfigurer freeMarkerConfigurer;

  @PostConstruct
  public void setSharedVariable()  {
    freeMarkerConfigurer.getConfiguration().setSharedVariable("shiro", new ShiroTags());
  }


}
