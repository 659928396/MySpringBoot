package com.lj.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/boot/sayHello")
    public String sayHello(){
        return "Hello SpringBoot!";
    }

}
