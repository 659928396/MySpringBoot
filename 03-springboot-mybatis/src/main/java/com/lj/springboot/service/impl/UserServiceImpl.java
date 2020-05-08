package com.lj.springboot.service.impl;

import com.lj.springboot.mapper.UserMapper;
import com.lj.springboot.model.User;
import com.lj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper; //idea会提示找不到这个bean，其实代码没错，可以修改idea对Autowired的提示
    @Autowired
    private RedisTemplate redisTemplate;//添加了springboot的redis依赖后，spring容器中添加专门操作redis的bean

    @Override
    public List<User> findAll() {
        RedisSerializer redisSerializer = new StringRedisSerializer();//字符串序列化器，优化存入redis的key值的可读性
        redisTemplate.setKeySerializer(redisSerializer);

        List<User> userList = (List<User>) redisTemplate.opsForValue().get("allUsers");//先从缓冲中获取
        //双重判断锁：先后两次判断从缓存中取出的对象，在第二次判断前加上同步锁。
        //1、同步锁限制只允许一个线程访问，因此第一个线程进入同步锁后，依然需要查询一次数据库。
        //2、高并发时，按照CPU的数量，一次可能同时16个线程一齐请求，那另外的15个线程，都穿过第一个if判断
        //    顺序进入同步锁内，此时第二个进入锁内的线程，从缓存中取到内容，并迅速返回。此后的18个线程也飞快返回。
        //3、剩余的9984个进程，在第一个if判断前，就可以从内存得到内容，直接返回，无需进入同步锁内。
        if(userList==null){
            synchronized (this){//同步锁
                userList = (List<User>) redisTemplate.opsForValue().get("allUsers");//先从缓冲中获取
                if(userList==null){//如果缓存中没有，再从数据库中查询
                    userList = userMapper.findAll();
                    redisTemplate.opsForValue().set("allUsers",userList);//存入nosql数据库redis中缓存起来
                    System.out.println("从数据库取......");
                }else{
                    System.out.println("从内存取");
                }
            }
        }else{
            System.out.println("从内存取");
        }
        return userList;
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
