package com.bbs.mapper;

import com.bbs.entity.Manager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ManagerMapper {

        @Insert("insert into manager_table(manager_id,manager_name,manager_password)values(#{id},#{name},#{password})")
        int insertManger(Manager manager);

        @Select("select * from manager_table where manager_id=#{id}")
        Manager selectById(String Id);

        @Select("select * from manager_table")
        List<Manager> selectAll();

        @Delete("delete from manager_table where id=#{id}")
        int deleteUser(String id);
}
