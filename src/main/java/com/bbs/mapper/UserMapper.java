package com.bbs.mapper;

import com.bbs.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user_table(tel_number,user_password,user_name,user_sex,user_sign,user_head,user_edu,user_job,user_work_place,user_register_time,user_birthday,user_home,user_integral,user_reputation_value)values(#{tel},#{password}),#{name},#{sex},#{sign},#{head},#{edu},#{job},#{workPlace},#{registerTime},#{birthday},#{home},#{integral},#{reputationValue}")
    int insertUser(User user);

    @Select("Select * from user_table")
    List<User> selectAll();

    @Select("Select * from user_table where tel_number = #{tel}")
    User selectById(String tel);

    @Delete("delete from user_table where tel_number=#{tel}")
    int deleteUser(String tel);

    @Update("Update user_table Set user_password = #{password},user_name= #{name},user_sex=#{sex},user_sign=#{sign},user_head=#{head},user_edu=#{edu},user_job=#{job},user_work_place=#{workPlace},user_register_time=#{registerTime},user_birthday=#{birthday},user_home=#{home},user_integral=#{integral},user_reputation_value=#{reputationValue}where id = #{id}")
    int updateInformation(User user);



}
