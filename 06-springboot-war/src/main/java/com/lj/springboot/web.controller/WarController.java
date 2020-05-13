package com.lj.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WarController {

    @RequestMapping("/boot/json")
    public @ResponseBody Object json(){
        Map map = new HashMap();
        map.put("name","ZhangSan");
        return map;
    }

    @RequestMapping("/boot/jsp")
    public String jsp(Model model){
       model.addAttribute("name","Lisi");
        return "index";
    }

}
