package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.entity.User;
import com.bbs.service.PostService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    public UserService userService;
    //首页URL通用：localhost：8080，根据所传参数来判断跳转到哪个页面
    @GetMapping({"/","/index.html"})
    public String indexPost(Model model, Map<String,Object> map, @RequestParam(name = "postType",required = false,defaultValue ="1" )Integer postType, @RequestParam(name = "indexType",required = false,defaultValue = "1")Integer indexType, @RequestParam(name="pageNumber" ,required = false,defaultValue = "1") Integer pageNumber){
        System.out.println("帖子类型："+postType);
        System.out.println("排序方式："+indexType);
        System.out.println("页数："+pageNumber);

        //判断“置顶”、“最新”，是否有翻页，以及按钮变色
        if(postType==4||postType==5){
            indexType=2;
        }
        if(indexType==1){
            map.put("pageButton","exit");
        }
        map.put("postType",postType);
        map.put("page",pageNumber);
        if(postType==1) {
            //左边页面显示的内容，"首页"
            if (indexType == 1) {
                //左边页面显示的内容，查询所有帖子，并按时间排序--》“最新”
                List<Post> newPosts = postService.findAllByPage(1,pageNumber,6);
                model.addAttribute("Post", newPosts);
            } else {
                //左边页面显示的内容，查询所有置顶帖子，并按时间排序--》“置顶”
                List<Post> newPosts = postService.findAllByPage(2,1,9);
                model.addAttribute("Post", newPosts);
            }
        }else if(postType==2){
            //左边页面显示的内容，"精品帖区"
            //左边页面显示的内容，查询所有加精帖子，并按时间排序--》“最新”
            List<Post> newPosts = postService.findAllByPage(3,pageNumber,6);
            model.addAttribute("Post", newPosts);
        } else if(postType==3){
            //左边页面显示的内容，"需求帖区"
            //左边页面显示的内容，查询所有需求帖子，并按时间排序--》“最新”
            List<Post> newPosts = postService.findAllByPage(4,pageNumber,6);
            model.addAttribute("Post", newPosts);
        }else if(postType==4){
            //左边页面显示的内容，"人气排行"
            //左边页面显示的内容，查询所有帖子，并按点赞数排序--》“最新”
            List<Post> newPosts = postService.findAllByPage(5,1,10);
            model.addAttribute("Post", newPosts);
        }else if(postType==5){
            //左边页面显示的内容，"积分排行"
            //左边页面显示的内容，查询所有用户，并按积分排序--》“最新”
            List<User> users0 =userService.selectAll() ;
//            List<User>  users1= users0.stream().sorted((a, b) -> a.getIntegral() - b.getIntegral()).collect(Collectors.toList());
            model.addAttribute("user", users0);
        }else if(postType==6){
            //左边页面显示的内容，"天健园"
            //左边页面显示的内容，查询所有天健园帖子，并按时间排序--》“最新”
            List<Post> newPosts = postService.findAllByPage(7,pageNumber,6);
            model.addAttribute("Post", newPosts);
        }else if(postType==7){
            //左边页面显示的内容，"休闲区"
            //左边页面显示的内容，查询所有休闲区帖子，并按时间排序--》“最新”
            List<Post> newPosts = postService.findAllByPage(8,pageNumber,6);
            model.addAttribute("Post", newPosts);
        }else if(postType==8){
            //左边页面显示的内容，"医学院"
            //左边页面显示的内容，查询所有医学院帖子，并按时间排序--》“最新”
            List<Post> newPosts = postService.findAllByPage(9,pageNumber,6);
            model.addAttribute("Post", newPosts);
        }

        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
        List<Post> hotMostPost=postService.findAllByPage(6,1,9);
        model.addAttribute("hotPost",hotMostPost);
        //右边页面显示的内容，查询点赞数最高的前6条帖子，在本周热点栏展示
        List<Post> popularMostPost=postService.findAllByPage(5,1,6);
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
//    @GetMapping("/toPost/{postID}")
    @GetMapping("/toPost")
    public String toPostPage(@RequestParam("postId") int postId, Model model,Map<String,Object> map){
        map.put("postId",postId);
        //查询该postID对应的帖子
        Post post=postService.findByPostID(postId);
        model.addAttribute("post",post);
        //查询该postID相应的评论
        List<Post> comments=postService.findPostByMainID(postId);
        model.addAttribute("comments",comments);
        //点击首页帖子标题跳转到该帖子详细界面
        return "tiezi";
    }
    //点击搜素按钮,根据输入关键字进行模糊查询；
    @GetMapping("/search")
    public String toSearch(@RequestParam("keyword") String keyword, Model model, Map<String,Object> map, HttpServletRequest request){
        System.out.println(keyword);
        map.put("keyword",keyword);
        List<Post> likelyPost=postService.findLikePostTitle(keyword);
        model.addAttribute("likelyPost",likelyPost);
        return "search";
    }
    //帖子页面点击发表评论
    @PostMapping("/writeComment")
    public String addCommit(@RequestParam("comment") String comment,@RequestParam("postId") int postId, HttpSession session){
        //新建一个评论对象
        Post newComment=new Post();
        newComment.setPosterID((String)session.getAttribute("tel"));
        newComment.setPosterName((String)session.getAttribute("username"));
        newComment.setMainPost(postId);
        newComment.setPostTime(new Timestamp((new Date()).getTime()));
        newComment.setPostContent(comment);
        postService.addPost(newComment);//将新建的评论对象存入帖子表
        return "redirect:/toPost";
    }
}
