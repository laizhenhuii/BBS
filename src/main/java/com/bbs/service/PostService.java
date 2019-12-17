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

    //查询所有帖子按发帖时间降序排序
    //然后分页查询，pageNum表示要查询第几页，pageSize表示每页查询多少条帖子
    //返回查询页所有的帖子
    public List<Post> findAllByPostTime(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return postMapper.findAllByPostTime();
    }

    //查询所有帖子按浏览量降序排序
    //然后分页查询，pageNum表示要查询第几页，pageSize表示每页查询多少条帖子
    //返回查询页所有的帖子
    public List<Post> findAllBypageView(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return postMapper.findAllBypageView();
    }

    //查询所有帖子按最后回复时间降序排序
    //然后分页查询，pageNum表示要查询第几页，pageSize表示每页查询多少条帖子
    //返回查询页所有的帖子
    public List<Post> findAllByLastPost(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return postMapper.findAllByLastPost();
    }

    //根据发帖人ID查询帖子（查询某个发帖人所有帖子）
    public List<Post> findByUserID(String UserID){
        return postMapper.findByUserID(UserID);
    }

    //根据帖子ID查询帖子
    public Post findByPostID(int PostID){
        return postMapper.findByPostID(PostID);
    }

    //分页查询帖子
    public List<Post> getPost(Integer page, Integer limit){
        return postMapper.findAll();
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
