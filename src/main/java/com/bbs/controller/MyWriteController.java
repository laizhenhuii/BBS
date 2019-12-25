package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.entity.User;
import com.bbs.service.PostService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MyWriteController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    //展示个人贴子页面
    @RequestMapping("/user/tiezi")
    public String showPoster(Model model, HttpSession session){
        List<Post> posts=postService.findMainByUserOrder(session.getAttribute("tel").toString());
        // String A = request.getSession().getAttribute("tel").toString();
        //System.out.println(A);
        model.addAttribute("posts",posts);
        return "myWrite";
    }
    //删除贴子
    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id){
        postService.deleteByPostID(id);

        return "redirect:/user/tiezi";
    }
    //阅读贴子
    @GetMapping("/readPost/{postID}")
    public String toPostPage(@PathVariable("postID") int id, Model model, Map<String, Object> map){
        map.put("postID",id);
        //查询该postID对应的帖子
        Post post=postService.findByPostID(id);
        model.addAttribute("post",post);
        //查询该postID相应的评论
        List<Post> comments=postService.findPostByMainID(id);
        model.addAttribute("comments",comments);
        //点击首页帖子标题跳转到该帖子详细界面
        return "tiezi";
    }
    //获取要修改贴子的id
    @RequestMapping("/changePost/{id}")
    public String changePostContent(Model model,@PathVariable int id){
        List<Post> post=new ArrayList<>();
        post.add(postService.findByPostID(id));
        model.addAttribute("post",post);
        return "changeContent";
    }

    @PostMapping("/saveChange")
    public String saveChange(@RequestParam(value = "title",required = false) String title,
                             @RequestParam(value = "text",required = false) String text,
                             @RequestParam(value = "type",required = false) String type,
                             //   @RequestParam(value = "file",required = false) MultipartFile file,
                             @RequestParam(value = "id",required = false) Integer id,
                             HttpSession session, Map<String,Object> map)throws Exception{
        Integer postID=id;

        Post post = postService.findByPostID(postID);
        String posterID=(String)session.getAttribute("tel"); //发帖人ID（手机号）

        //以下帖子内容初始化

        String postTitle=title;//帖子标题
        String temp=text.replace("\n","<br/>");//帖子格式化临时变量
        String postContent=temp.replace(" ","&nbsp");//帖子内容
        boolean homeTop=false; //是否首页置顶，为true时置顶
        String moduleType=type;//版块类型，如天健轶事

        //   String imageAddress=null; //帖子图片地址

        //将获取到的帖子信息放到实体类中
        post.setPostTitle(postTitle);
        post.setPostContent(postContent);
        post.setModuleType(moduleType);
        //    post.setImageAddress(imageAddress);

        postService.updatePost(post);          //更新贴子信息
        return "redirect:/user/tiezi";
    }
}


