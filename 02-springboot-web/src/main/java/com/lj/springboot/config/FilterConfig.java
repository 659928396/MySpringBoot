package com.lj.springboot.config;

import com.lj.springboot.web.filter.HeFilter;
import com.lj.springboot.web.servlet.HeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean heFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HeFilter());
        filterRegistrationBean.addUrlPatterns("/HeFilter");
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean characterEnconfingFilterRegistrationBean(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();//spring的编码处理过滤器
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("gbk");

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HeFilter());
        filterRegistrationBean.setFilter(characterEncodingFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
