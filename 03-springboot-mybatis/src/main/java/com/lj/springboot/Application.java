package com.lj.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.lj.springboot.mapper") //扫描mybatis的mapper接口
@EnableTransactionManagement //开启事务管理
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
