package com.lj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //标记这是springboot的引导类
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);  //springboot的启动方式
    }

}
