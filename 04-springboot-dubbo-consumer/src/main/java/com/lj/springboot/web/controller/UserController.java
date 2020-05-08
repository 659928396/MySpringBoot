package com.lj.springboot.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference //引用dubbo服务提供者的服务
    private UserService userService;

    @RequestMapping("/boot/dubbo/user")
    public Object getUser(int id) {
        System.out.println("----------------------  "+id);
        return userService.getUser(id);
    }

}
