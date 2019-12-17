package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @GetMapping({"/","/index.html"})
    public String toHomePage(Model model){
        //左边页面显示的内容，默认是“置顶效果”
        List<Post> likeMostPost=postService.findAll();
        model.addAttribute("Post",likeMostPost);
        //右边页面显示的内容，本周热议
        List<Post> hotMostPost=postService.findAllBypageView(1,9);
        model.addAttribute("hotPost",hotMostPost);
        //加载首页
        return "index";
    }
    //点击“最新”后，刷新首页，左边帖子按时间降序展示
    @GetMapping("/homePage/{pageNumber}")
    public String toNewPost(Model model, Map<String,Object> map,@PathVariable("pageNumber") Integer pageNumber){
        //左边页面显示的内容，按发布时间排序
        List<Post> newPosts=postService.findAllByPostTime(pageNumber,9);
        model.addAttribute("Post",newPosts);

        map.put("ms1","1");
        //右边页面显示的内容
        List<Post> hotMostPost=postService.findAllBypageView(1,9);
        model.addAttribute("hotPost",hotMostPost);
        //重新加载首页
        return "index";
    }
    //点击“置顶”后，重新加载首页，因为首页默认为置顶所以链接地址为@{/}
    //点击“精品区”，重新加载页面，查询精品贴
    public String toBoutiquePost(){
        return "index";
    }
    //点击登录后的头像，来到个人信息设置界面
    @GetMapping("/toMyHome")
    public String toMyHome(){
        return "home";
    }
    //点击发新帖，转发到写帖子界面
    @GetMapping("/writePost")
    public String toWritePage(){
        //点击发新帖到写帖子界面
        return "write";
    }
    //点击某个首页上帖子的某个帖子时，跳转到该帖子的详细界面
    @GetMapping("/toPost/{postID}")
    public String toPostPage(@PathVariable("postID") int postId,Model model){
        Post post=postService.findByPostID(postId);
        model.addAttribute("post",post);
        //跳转到该帖子详细界面
        return "tiezi";
    }
}
