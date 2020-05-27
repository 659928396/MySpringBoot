package com.lj.springboot.web.controller;

import com.lj.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @RequestMapping("/boot/thymeleaf/index")
    public String index(Model model){
        model.addAttribute("msg","SpringBoot集成Thymeleaf");

        User user = new User();
        user.setId(1);
        user.setName("ZhangSan");
        user.setAddress("天府路177号");
        //user.setEmail("123456@163.com");
        model.addAttribute("user",user);

        List<User> userList = new ArrayList<User>();
        for(int i=0;i<10;i++){
            User u = new User();
            u.setId(i+1);
            u.setName("用户编号："+u.getId()+"号");
            u.setAddress(u.getId()+"号宿舍");
            userList.add(u);
        }
        model.addAttribute("userList",userList);

        Map userMap = new HashMap();
        userMap.put("1","ZhangSan");
        userMap.put("2","LiSi");
        model.addAttribute("userMap",userMap);

        String[] types = {"String","int","boolean"};
        model.addAttribute("types",types);

        model.addAttribute("sex","0");

        return "index";//会导航至/resources下的index.html
    }

}
