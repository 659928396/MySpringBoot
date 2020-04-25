package com.lj.springboot.web.controller;

import com.lj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
