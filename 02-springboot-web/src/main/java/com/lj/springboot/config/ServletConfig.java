package com.lj.springboot.config;

import com.lj.springboot.web.filter.HeFilter;
import com.lj.springboot.web.servlet.HeServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        return new ServletRegistrationBean(new HeServlet(),"/HeServlet");//注册Servlet
    }

}
