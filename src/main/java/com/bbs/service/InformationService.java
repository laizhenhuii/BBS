package com.bbs.service;

import com.bbs.entity.Information;
import com.bbs.entity.Post;
import com.bbs.mapper.InformationMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//具体接口使用可看controller中的yjwtest类

@Service
public class InformationService {
    @Resource
    private InformationMapper informationMapper;

    //增加一条消息
    public int addInformation(Information information){
        if(informationMapper.addInformation(information) != 0)
            return 1;
        else
            return 0;
    }

    //通过消息的id删除消息
    public int deleteByInformationID(int informationID){
        if(informationMapper.deleteByInformationID(informationID) != 0)
            return 1;
        else
            return 0;
    }

    //按照发帖人ID删除帖子（清空消息）
    public int deleteByUserID(String receiverTel){
        if(informationMapper.deleteByUserID(receiverTel) != 0)
            return 1;
        else
            return 0;
    }

    //查询所有消息
    public List<Information> findAll(){
        return informationMapper.findAll();
    }

    //根据接收人ID查询消息（查询某个接收人所有消息）
    public List<Information> findByReceiverTel(String receiverTel){
        return informationMapper.findByReceiverTel(receiverTel);
    }

    public Information findByInformationID(int informationID){
        return informationMapper.findByInformationID(informationID);
    }

}
