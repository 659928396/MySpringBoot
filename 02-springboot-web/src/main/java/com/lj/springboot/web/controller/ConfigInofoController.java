package com.lj.springboot.web.controller;

import com.lj.springboot.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigInofoController {
    @Value("${boot.name}") //读取配置文件内key为boot.name的值，并注入到该属性
    private String name;
    @Value("${boot.location}") //读取配置文件内key为boot.location的值，并注入到该属性
    private String location;

    @Autowired
    private ConfigInfo configInfo; //注入配置类

    @RequestMapping("/boot/config")
    public String config(){
        return name+"---"+location+"---"+configInfo.getPort();
    }
}
