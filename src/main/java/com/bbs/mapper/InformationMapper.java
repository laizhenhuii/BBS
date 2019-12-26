package com.bbs.mapper;

import com.bbs.entity.Information;
import com.bbs.entity.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
@Service
public interface InformationMapper {


    @Insert("insert into information_table(originContent, receiverTel, reason, postTime, originTitle, haveRead, informationID, posterID, postID)" +
            "values(#{originContent}, #{receiverTel}, #{reason}, #{postTime}, #{originTitle}, #{haveRead}, #{informationID}, #{posterID}, #{postID})")
    int addInformation(Information information);


    @Delete("delete from information_table where informationID=#{informationID}")
    int deleteByInformationID(int informationID);

    @Delete("delete from information_table where receiverTel=#{receiverTel}")
        //按照发帖人ID删除帖子（清空消息）
    int deleteByUserID(String receiverTel);

    @Select("select * from information_table")
        //查询所有帖子
    List<Information> findAll();

    @Select("select * from information_table where receiverTel = #{receiverTel}")
        //根据接收人ID查询消息（查询某个接收人所有消息）
    List<Information> findByReceiverTel(String receiverTel);

    @Select("select * from information_table where informationID = #{informationID}")
        //根据消息ID查询消息
    Information findByInformationID(int informationID);

}
