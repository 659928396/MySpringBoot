package com.lj.springboot.web.controller;

import com.lj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/boot/users")
    public Object users(){
        return userService.findAll();
    }

    @GetMapping("/boot/updateUser")
    public Object updateUser(){
        return userService.update();
    }

    @RequestMapping("/boot/redis")
    public Object redis(){
        //高并发测试缓存穿透问题
        ExecutorService executorService = Executors.newFixedThreadPool(16);//16个线程
        for (int i=0;i<1000;i++){//并发1000个请求
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    userService.findAll();
                }
            });
        }

        return userService.findAll();
    }
}
