package com.basic.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Properties;

/**
 * springboot 自动配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            registry.addResourceHandler("/view/**").addResourceLocations("classpath:/view/");
            super.addResourceHandlers(registry);
        }

}
