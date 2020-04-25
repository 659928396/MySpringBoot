package com.lj.springboot.mapper;

import com.lj.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper //标记该类为Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();
}