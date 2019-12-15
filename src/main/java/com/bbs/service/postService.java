package com.bbs.service;

import com.bbs.entity.Post;
import com.bbs.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class postService {
    @Resource
    PostMapper postMapper;


}
