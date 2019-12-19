package com.bbs.service;

import com.bbs.entity.Post;
import com.bbs.mapper.PostMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

//具体接口使用可看controller中的yjwtest类

@Service
public class PostService {
    @Resource
    PostMapper postMapper;

    //添加一条新帖(返回1表示成功，0表示失败，下面类似)
    public int addPost(Post post){
        if(postMapper.addPost(post) != 0)
            return 1;
        else
            return 0;
    }

    //按照帖子ID删除一条帖子
    public int deleteByPostID(int PostID){
        if(postMapper.deleteByPostID(PostID) != 0)
            return 1;
        else
            return 0;
    }

    //按照发帖人ID删除帖子
    public int deleteByUserID(String UserID){
        if(postMapper.deleteByUserID(UserID) != 0)
            return 1;
        else
            return 0;
    }

    //查询所有帖子
    public List<Post> findAll(){
        return postMapper.findAll();
    }


    public List<Post> findAllByPostTime(int pageNum, int pageSize){
        return postMapper.findAllByLastPost(-1);
    }

    public List<Post> findAllBypageView(int pageNum, int pageSize){
        return postMapper.findAllByPageView(-1);
    }



    //分页查询，pageNum表示要查询第几页，pageSize表示每页查询多少条帖子
    //返回查询页所有的帖子
    //type字段为1查询首页帖子，2查询置顶帖子，3查询精品帖子
    //          4查询需求帖子，5点赞数排序，6浏览量排序
    //          7天健园， 8休闲区， 9医学院
    public List<Post> findAllByPage(int type, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        if(type == 1)
            return postMapper.findAllByLastPost(-1);
        else if(type == 2)
            return postMapper.findAllHomeTop(-1, true);
        else if(type == 3)
            return postMapper.findAllBoutuque(-1, true);
        else if(type == 4)
            return postMapper.findAllpostIntegral(-1);
        else if(type == 5)
            return postMapper.findAllByLikeNumber(-1);
        else if(type == 6)
            return postMapper.findAllByPageView(-1);
        else if(type == 7)
            return postMapper.findAllBymoduleType(-1, "天健园");
        else if(type == 8)
            return postMapper.findAllBymoduleType(-1, "休闲区");
        else if(type == 9)
            return postMapper.findAllBymoduleType(-1, "医学院");
        else
            return null;
    }



    //根据发帖人ID查询帖子（查询某个发帖人所有帖子）
    public List<Post> findByUserID(String UserID){
        return postMapper.findByUserID(UserID);
    }

    //根据帖子ID查询帖子
    public Post findByPostID(int PostID){
        return postMapper.findByPostID(PostID);
    }

    //根据主贴id查找评论帖
    public List<Post> findPostByMainID(int PostID){
        return postMapper.findPostByMainID(PostID);
    }

    //根据关键词模糊查询帖子（仅匹配标题）
    public List<Post> findLikePostTitle(String postTitle){
        String rePostTitle = "%" + postTitle + "%";
        return postMapper.findLikePostTitle(rePostTitle);
    }

    //修改某条帖子信息
    //请用findByPostID找到该条帖子，
    //然后将想要修改的字段覆盖，再传入此函数
    public int updatePost(Post post){
        if(postMapper.updatePost(post) != 0)
            return 1;
        else
            return 0;
    }



}
