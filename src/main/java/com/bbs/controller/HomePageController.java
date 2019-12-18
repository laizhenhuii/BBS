package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String toHomePage(Model model, Map<String,Object> map){
        //左边页面显示的内容，默认是“最新”，并查询数据库，按时间降序展示
        List<Post> newPosts=postService.findAllByPostTime(1,6);
        model.addAttribute("Post",newPosts);
        //判断“最新”、“置顶”,用于滚动栏的隐藏判断
        map.put("ms1","1");
        //右边页面显示的内容，本周热议
        List<Post> hotMostPost=postService.findAllBypageView(1,9);
        model.addAttribute("hotPost",hotMostPost);
        //加载首页
        return "index";
    }
    //点击“置顶”后，刷新首页，展示置顶帖
    @GetMapping("/topPost")
    public String toNewPost(Model model){
        //左边页面显示的内容，置顶帖
        List<Post> post=postService.findAll();
        model.addAttribute("Post",post);
        //右边页面显示的内容
        List<Post> hotMostPost=postService.findAllBypageView(1,9);
        model.addAttribute("hotPost",hotMostPost);
        //重新加载首页
        return "index";
    }
    //点击“最新”后，重新加载首页，因为首页默认为最新所以链接地址为@{/}
    //点击“首页”后，重新加载首页，所以@{/}
    //点击“精品区”，按是否精品帖进行查询，并重新加载页面，并展示查询到的精品贴
//    @GetMapping("/boutiquePost")
//    public String toBoutiquePost(Model model){
//        return "index";
//    }
    //点击“积分商城”，来到积分商城界面
//    @GetMapping("/homePage/boutique")
//    public String toBoutiquePost(Model model){
//        return "index";
//    }
    //点击“人气排行”，来到排行界面
//    @GetMapping("/homePage/boutique")
//    public String toBoutiquePost(Model model){
//        return "index";
//    }
    //点击“type1”，按“type1”进行查询，并重新加载界面，并展示查询到的……帖
//    @GetMapping("/homePage/boutique")
//    public String toBoutiquePost(Model model){
//        return "index";
//    }
    //点击“type2”，按“type2”进行查询，并重新加载界面，并展示查询到的……帖
//    @GetMapping("/homePage/boutique")
//    public String toBoutiquePost(Model model){
//        return "index";
//    }
    //点击“type3”，按“type3”进行查询，并重新加载界面，并展示查询到的……帖
//    @GetMapping("/homePage/boutique")
//    public String toBoutiquePost(Model model){
//        return "index";
//    }
    //点击“需求区”，重新加载页面，并查询需求贴
//    @GetMapping("/homePage/boutique")
//    public String toBoutiquePost(Model model){
//        return "index";
//    }
    //点击登录后的头像，根据用户ID查询用户信息，来到个人信息设置界面
    @GetMapping("/toMyHome")
    public String toMyHome(){
        return "home";
    }
    //点击发新帖，根据用户ID，来到写帖子界面
    @GetMapping("/writePost")
    public String toWritePage(){
        //点击发新帖到写帖子界面
        return "write";
    }
    //点击首页上某个帖子的标题时，获取该帖子ID，并跳转到该帖子的详细界面
    @GetMapping("/toPost/{postID}")
    public String toPostPage(@PathVariable("postID") int postId, Model model){
        Post post=postService.findByPostID(postId);
        model.addAttribute("post",post);
        //点击首页帖子标题跳转到该帖子详细界面
        return "tiezi";
    }
}
