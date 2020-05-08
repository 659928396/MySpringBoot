package com.lj.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Component;

@Component
@Service //标记这个service实现类为一个dubbo的服务类
public class UserServiceImpl implements UserService {
    @Override
    public String sayHi(String name) {
        return "Hi "+name;
    }

    @Override
    public User getUser(int id) {
        User user = new User();
        user.setId(id);
        user.setAge(18);
        user.setName("Zhang San");
        return user;
    }
}
