package com.lj.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lj.springboot.mapper.UserMapper;
import com.lj.springboot.model.User;
import com.lj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component //spring的注解
@Service //dubbo的注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;//添加了springboot的redis依赖后，spring容器中添加专门操作redis的bean

    @Override
    public List<User> selectUsersByPage(Map<String, Object> paramsMap) {
        return userMapper.selectByPage(paramsMap);
    }

    @Override
    public int selectUsersTotal() {
        Integer total = (Integer) redisTemplate.opsForValue().get("total");//先从缓冲中获取
        if(total==null){//如果缓存中没有，再从数据库中查询
            synchronized (this){
                total = (Integer) redisTemplate.opsForValue().get("total");//先从缓冲中获取
                if(total==null){
                    total = userMapper.selectTotal();
                    redisTemplate.opsForValue().set("total",total);//存入nosql数据库redis中缓存起来
                }
            }
        }
        return total;
    }

    @Override
    public User selectUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(User user) {
        int oprNum = userMapper.insert(user);
        if(oprNum>0){
            redisTemplate.delete("total");
        }
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void delete(int id) {
        int oprNum = userMapper.deleteByPrimaryKey(id);
        if(oprNum>0){
            redisTemplate.delete("total");
        }
    }
}
