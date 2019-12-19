package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    //首页URL通用：localhost：8080，根据所传参数来判断跳转到哪个页面
    @GetMapping("/")
    public String indexPost(Model model, Map<String,Object> map, @RequestParam(name = "postType",required = false,defaultValue ="1" )Integer postType, @RequestParam(name = "indexType",required = false,defaultValue = "1")Integer indexType, @RequestParam(name="pageNumber" ,required = false,defaultValue = "1") Integer pageNumber){
        System.out.println("帖子类型："+postType);
        System.out.println("排序方式："+indexType);
        System.out.println("页数："+pageNumber);

        //判断“置顶”、“最新”，是否有翻页，以及变色
        if(indexType==1){
            map.put("pageButton","exit");
        }
        map.put("postType",postType);
        if(postType==1) {
            //左边页面显示的内容，"首页"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==2){
            map.put("postType",postType);
            //左边页面显示的内容，"精品帖区"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==3){
            map.put("postType",postType);
            //左边页面显示的内容，"需求帖区"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==4){
            map.put("postType",postType);
            //左边页面显示的内容，"人气排行"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==5){
            map.put("postType",postType);
            //左边页面显示的内容，"积分商城"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==6){
            map.put("postType",postType);
            //左边页面显示的内容，"天健园"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==7){
            map.put("postType",postType);
            //左边页面显示的内容，"休闲区"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==8){
            map.put("postType",postType);
            //左边页面显示的内容，"医学院"
            if (indexType == 1) {
                //左边页面显示的内容，“最新”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，“置顶”
                List<Post> newPosts = postService.findAllByPostTime(pageNumber, 6);
                model.addAttribute("Post", newPosts);
            }
        }

        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
        List<Post> hotMostPost=postService.findAllBypageView(1,9);
        model.addAttribute("hotPost",hotMostPost);
        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
        List<Post> popularMostPost=postService.findAllBypageView(2,5);
        model.addAttribute("popularPost",popularMostPost);

        //加载首页
        return "index";
    }
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
    //点击搜素按钮,根据输入关键字进行模糊查询；
    @PostMapping("/search")
    public String toSearch(@RequestParam("keyword") String keyword, Model model){
        System.out.println(keyword);
        return "index";
    }
}
