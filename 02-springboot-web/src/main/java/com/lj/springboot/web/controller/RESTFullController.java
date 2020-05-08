package com.lj.springboot.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RESTFullController {

    //http://localhost:8090/02-springboot-web/boot/rest/123/lisi
    @RequestMapping("/boot/rest/{id}/{name}")
    public Object rest(@PathVariable("id") Integer id,@PathVariable("name") String name) {
        System.out.println("rest running...");
        Map map = new HashMap();
        map.put("id",id);
        map.put("name",name);
        return map;
    }

}
