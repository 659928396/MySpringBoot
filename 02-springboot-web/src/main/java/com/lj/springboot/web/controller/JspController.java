package com.lj.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {

    @GetMapping("/boot/jsp/index")
    public String index(Model model){
        model.addAttribute("name", "张三");
        return "index";
    }

}
