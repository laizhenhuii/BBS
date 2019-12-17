package com.bbs.service;

import com.bbs.entity.User;
import com.bbs.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public boolean registerUser(String tel,String password){     //注册，用账号密码注册
        User temp=userMapper.selectByTel(tel);
        if(temp==null){
            userMapper.registerUser(tel,password);
            return true;
        }
        return false;
    }

    public int login(String tel,String password){          //登录，登录成功返回1，未找到返回0，密码错误返回-1
        User temp=userMapper.selectByTel(tel);
        if(temp==null){
            return 0;
        }
        else if(temp.getPassword().equals(password)){
            return 1;
        }
        return -1;
    }
    public void deleteUser(String tel){
        userMapper.deleteUser(tel);
    } //删除某个用户信息，供管理员调用

    public int updateInformation(User user){              //更新某个用户信息，先用selectByTel找到
        if(userMapper.updateInformation(user)!= 0)
            return 1;
        else
            return 0;
    }

    public User selectByTel(String tel){
        return ( userMapper.selectByTel(tel));//根据用户tel查询用户全部个人信息
    }

    //根据关键词模糊查询用户（仅匹配用户名）
    public List<User> findLikeUserName(String userName){
        String reUserName = "%" + userName + "%";
        return userMapper.findLikePostTitle(reUserName);
    }

    public int selectIntegral(String tel){
        return (userMapper.selectIntegral(tel));//根据用户tel查询用户积分
    }
    public int selectValue(String tel){
        return (userMapper.selectValue(tel));//根据用户tel查询用户信誉值
    }
    public List<User> selectAll(){
        return userMapper.selectAll();
    }  //查询所有用户信息


}
