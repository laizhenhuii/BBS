package com.bbs.mapper;

import com.bbs.entity.Post;

import java.util.List;

public interface PostMapper {

    //添加一条新帖(返回1表示成功，0表示失败，下面类似)
    int addPost(Post post);

    //按照帖子ID删除一条帖子
    int deleteByPostID(int PostID);

    //按照发帖人ID删除帖子
    int deleteByUserID(int UserID);

    //查询所有帖子
    List<Post> findAll();

    //根据发帖人ID查询帖子（查询某个发帖人所有帖子）
    List<Post> findByUserID(int UserID);

    //根据帖子ID查询帖子
    Post findByPostID(int PostID);

    //修改某条帖子信息
    //请用findByPostID找到该条帖子，
    //然后将想要修改的字段覆盖，再传入此函数
    int changePost(Post post);

}
