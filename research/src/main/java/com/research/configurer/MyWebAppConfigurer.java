package com.research.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置静态资源访问路径
 *
 * @author shc
 * @date 2018-06-18
 **/

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    /**
     * 允许通过网络访问静态资源
     * 如：http://localhost:8090/images/IMG41.jpg
     * <p>
     * /images/**  指匹配的url
     * classpath:/images/  定位的资源路径位置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(10000L);
    }


}


