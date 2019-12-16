package com.bbs.service;

import com.bbs.entity.Manager;
import com.bbs.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerService {
    @Resource
    ManagerMapper managerMapper;

    public List<Manager> selectAll(){

        return managerMapper.selectAll();
    }  //查询所有管理员信息
    public void deleteManager(String tel){
        managerMapper.deleteUser(tel);
    } //删除某个管理员信息
    public Manager selectByTel(String id){
        return ( managerMapper.selectById(id));
    }//根据管理员Id查询个人信息

}
