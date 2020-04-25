package com.lj.springboot.service.impl;

import com.lj.springboot.mapper.UserMapper;
import com.lj.springboot.model.User;
import com.lj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper; //idea会提示找不到这个bean，其实代码没错，可以修改idea对Autowired的提示

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Transactional //对方法添加事务
    @Override
    public int update() {
        User user = userMapper.selectByPrimaryKey(1);
        user.setUsername("王五-update2");
        int oprNum = userMapper.updateByPrimaryKey(user);
        System.out.println("更新记录数："+oprNum);

        //抛出运行时异常
        int i = 1/0;

        return oprNum;
    }

}
