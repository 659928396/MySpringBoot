package com.lj.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration //开启Dubbo的配置支持，配置后，可以识别Dubbo的service
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
