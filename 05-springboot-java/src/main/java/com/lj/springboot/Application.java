package com.lj.springboot;

import com.lj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

    //springboot普通java项目方式一（非web项目）
    /*public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        String sayHi = userService.sayHi("ZhangSan");
        System.out.println(sayHi);
    }*/

    //springboot普通java项目方式二（非web项目）
    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        String sayHi = userService.sayHi("LiSi");
        System.out.println(sayHi);
    }
}
