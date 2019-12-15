package com.bbs.mapper;

import com.bbs.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface PostMapper {

    @Insert("insert into post_table(poster_id, poster_name, post_id, post_title, main_post, post_time, like_number, page_view, post_content, home_top, personal_top, post_boutique, post_integral, modle_Type)" +
            "values(#{posterID}, #{posterName}, #{postID}, #{postTitle}, #{mainPost}, #{postTime}, #{likeNumber}, #{pageView}, #{content}, #{homeTop}, {personalTop}, #{postBoutique}, #{postIntegral}, #{moudleType)")
    //添加一条新帖(返回1表示成功，0表示失败，下面类似)
    int addPost(Post post);


    @Delete("delete from post_table where post_id=#{postID}")
    //按照帖子ID删除一条帖子
    int deleteByPostID(int PostID);

    @Delete("delete from post_table where poster_id=#{posterID}")
    //按照发帖人ID删除帖子
    int deleteByUserID(int UserID);

    @Select("select * from post_table")
    //查询所有帖子
    List<Post> findAll();

    @Select("select * from post_table where poster_id = #{posterID}")
    //根据发帖人ID查询帖子（查询某个发帖人所有帖子）
    List<Post> findByUserID(int UserID);

    @Select("select * from post_table where post_id = #{postID}")
    //根据帖子ID查询帖子
    Post findByPostID(int PostID);


//    UPDATE tb_courses_new
//    -> SET course_name='DB',course_grade=3.5
//    -> WHERE course_id=2;
//
    @Update("update post_table set poster_id = #{posterID}")
    //修改某条帖子信息
    //请用findByPostID找到该条帖子，
    //然后将想要修改的字段覆盖，再传入此函数
    int changePost(Post post);

}



















