package com.lj.springboot.config;

import com.lj.springboot.web.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * spring的配置类，可以添加拦截器
 */
@Configuration //标记为配置类，才能够被springboot扫描到
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        interceptorRegistration.addPathPatterns("/boot/**");//设置被拦截的路径，入参为可变参数列表
        interceptorRegistration.excludePathPatterns("/boot/sayHello");//设置不拦截的路径
        //也可以三行代码，写成一行
    }
}
