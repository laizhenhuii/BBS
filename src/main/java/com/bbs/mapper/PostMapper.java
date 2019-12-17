package com.bbs.mapper;

import com.bbs.entity.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;



@Mapper
@Repository
@Service
public interface PostMapper {

    @Insert("insert into post_table(posterID, posterName, postTitle, mainPost, postTime, likeNumber, pageView, postContent, homeTop, personalTop, postBoutique, postIntegral, moduleType, lastPost, imageAddress)" +
            "values(#{posterID}, #{posterName}, #{postTitle}, #{mainPost}, #{postTime}, #{likeNumber}, #{pageView}, #{postContent}, #{homeTop}, #{personalTop}, #{postBoutique}, #{postIntegral}, #{moduleType}, #{lastPost}, #{imageAddress})")
    //添加一条新帖(返回1表示成功，0表示失败，下面类似)
    int addPost(Post post);


    @Delete("delete from post_table where postID=#{postID}")
    //按照帖子ID删除一条帖子
    int deleteByPostID(int PostID);

    @Delete("delete from post_table where posterID=#{posterID}")
    //按照发帖人ID删除帖子
    int deleteByUserID(String UserID);

    @Select("select * from post_table")
    //查询所有帖子
    List<Post> findAll();

    @Select("select * from post_table order by postTime DESC")
    //查询所有帖子按发帖时间降序排序
    List<Post> findAllByPostTime();

    @Select("select * from post_table order by pageView DESC")
    //查询所有帖子按浏览量降序排序
    List<Post> findAllBypageView();

    @Select("select * from post_table order by lastPost DESC")
    //查询所有帖子按最后回复时间降序排序
    List<Post> findAllByLastPost();

    @Select("select * from post_table where posterID = #{posterID}")
    //根据发帖人ID查询帖子（查询某个发帖人所有帖子）
    List<Post> findByUserID(String UserID);

    @Select("select * from post_table where postID = #{postID}")
    //根据帖子ID查询帖子
    Post findByPostID(int postID);


    @Update("update post_table set posterID = #{posterID}, posterName = #{posterName}, postTitle = #{postTitle}, mainPost = #{mainPost}, postTime = #{postTime}, " +
            "likeNumber = #{likeNumber}, pageView = #{pageView}, postContent = #{postContent}, homeTop = #{homeTop}, postBoutique = #{postBoutique}, " +
            "postIntegral = #{postIntegral}, moduleType = #{moduleType},  lastPost = #{lastPost}, imageAddress = #{imageAddress} where postID = #{postID}")
    //修改某条帖子信息
    //请用findByPostID找到该条帖子，
    //然后将想要修改的字段覆盖，再传入此函数
    int updatePost(Post post);

}



















