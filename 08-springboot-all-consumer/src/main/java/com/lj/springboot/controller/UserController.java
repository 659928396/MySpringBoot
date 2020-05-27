package com.lj.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lj.springboot.model.User;
import com.lj.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Reference //dubbo的注解
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") Integer curPage) {
        int pageSize = 5; //一页多少条记录

        int total = userService.selectUsersTotal(); //总记录数
        int pageCount = (total % pageSize > 0) ? (total / pageSize + 1) : (total / pageSize); //一共多少页
        if (curPage > pageCount) {
            curPage = pageCount;
        } else if (curPage < 1) {
            curPage = 1;
        }

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        int startRow = (curPage - 1) * pageSize;
        paramsMap.put("startRow", startRow);
        paramsMap.put("pageSize", pageSize);
        List<User> userList = userService.selectUsersByPage(paramsMap);

        model.addAttribute("total", total);
        model.addAttribute("userList", userList);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("curPage", curPage);
        return "index"; //会导航至/resources下的index.html
    }

    @RequestMapping("/user/toMerge")
    public String toMerge(Model model, @RequestParam(required = false) Integer id) {
        if (id != null) {
            User user = userService.selectUser(id);
            model.addAttribute("user", user);
        }
        return "mergeUser";
    }

    @RequestMapping("/user/merge")
    public String merge(User user) {
        if (user.getId() == null) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return "redirect:/index";
    }

    @RequestMapping("/user/delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/index";
    }

}
