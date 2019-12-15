package com.bbs.service;

import com.bbs.entity.User;
import com.bbs.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userService {
    @Resource
    UserMapper userMapper;
    public boolean insertUser(String id){
        User temp=userMapper.selectById(id);
        if(temp==null){
            User user = new User();
            userMapper.insertUser(user);
            return true;
        }
        return false;
    }

    public int login(String tel,String password){
        User temp=userMapper.selectById(tel);
        if(temp==null){
            return 0;
        }
        else if(temp.getPassword().equals(password)){
            return 1;
        }
        return -1;
    }


    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    public void deleteUser(String id){
        userMapper.deleteUser(id);
    }
}
