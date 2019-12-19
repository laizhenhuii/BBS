package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manages")
public class ManagerController {
    @Autowired
    public PostService postService;


    @RequestMapping("/postTable")
    public List<Post> postTable(){
//        System.out.println(postService.findAll());
        return postService.findAll();
    }

}
