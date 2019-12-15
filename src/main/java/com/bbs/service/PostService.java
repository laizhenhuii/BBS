package com.bbs.service;

import com.bbs.entity.Post;
import com.bbs.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {
    @Resource
    PostMapper postMapper;

    public List<Post> findAll(){
        return postMapper.findAll();
    }
}
