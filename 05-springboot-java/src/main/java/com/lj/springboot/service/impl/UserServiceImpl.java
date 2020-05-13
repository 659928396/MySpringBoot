package com.lj.springboot.service.impl;

import com.lj.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sayHi(String name) {
        return "Hi " + name;
    }
}
