package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName HomePageController
 * @Description 网站首页设计
 * @Author ZengChun
 * @Date 2019/12/15 18:15
 **/
@Controller
public class HomePageController {
    @Autowired
    public PostService postService;
    //8080端口直接进入网站首页，同时显示网站首页的有关信息
    @GetMapping("/")
    public String toHomePage(Model model){
        //从数据库获取网站首页待显示的信息
        List<Post> post=postService.findAll();
        model.addAttribute("post0",post);
        //输入8080进入到网站首页
        return "index";
    }
    //点击发新帖，转发到写帖子界面
    @GetMapping("/writePost")
    public String toWritePage(){
        //点击发新帖到写帖子界面
        return "write";
    }
}
