package com.lj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication //标记这是springboot的引导类
@ServletComponentScan(basePackages = {"com.lj.springboot.web.servlet","com.lj.springboot.web.filter"}) //扫描含WebServlet、WebFilter注解的类所在的包
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);  //springboot的启动方式
    }

}
