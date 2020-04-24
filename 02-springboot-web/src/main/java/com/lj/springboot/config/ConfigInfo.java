package com.lj.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //必须配置上，否则无法在别的类里注入该配置类
@ConfigurationProperties(prefix = "server") //将该类当作配置类，映射配置文件中server.开头的键
public class ConfigInfo {

    private String port; //映射配置文件中server.port的健

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
