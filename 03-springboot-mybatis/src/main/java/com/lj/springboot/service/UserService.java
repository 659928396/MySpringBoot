package com.lj.springboot.service;

import com.lj.springboot.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public int update();
}
