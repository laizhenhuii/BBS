package com.bbs.mapper;

import com.bbs.entity.Manager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ManagerMapper {

        @Insert("insert into manager_table(id,name,password)values(#{id},#{name},#{password})")
        int insertManger(Manager manager);         //管理员登录，暂时不用这个，管理员在数据库中直接初始化

        @Select("select * from manager_table where id=#{id}")
        Manager selectById(String Id);            //查看某个管理员的信息

        @Select("select * from manager_table")
        List<Manager> selectAll();             //查看所有管理员信息

        @Delete("delete from manager_table where id=#{id}")
        int deleteUser(String id);          //根据Id删除某个管理员信息
}
