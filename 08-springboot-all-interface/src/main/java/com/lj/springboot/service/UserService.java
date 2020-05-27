package com.lj.springboot.service;

import com.lj.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> selectUsersByPage(Map<String,Object> paramsMap);

    public int selectUsersTotal();

    User selectUser(int id);

    void save(User user);

    void update(User user);

    void delete(int id);
}
