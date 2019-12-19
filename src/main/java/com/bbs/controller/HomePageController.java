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
    //8080端口直接进入网站首页，同时显示网站首页的有关信息
//    @GetMapping({"/","/index.html"})
//    public String toHomePage(Model model, Map<String,Object> map,@RequestParam(name="page" ,required = false,defaultValue = "1")Integer page){
//        System.out.println(page);
//        //左边页面显示的内容，默认是“最新”，并查询数据库，按时间降序展示
//        List<Post> newPosts=postService.findAllByPostTime(page,6);
//        model.addAttribute("Post",newPosts);
//        //是否为空用于，判断“最新”、“置顶”,用于滚动栏的隐藏判断；具体String用于判断类型
//        map.put("pageButton","/");
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(2,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }

//    //点击“置顶”后，刷新首页，展示置顶帖
//    @GetMapping("/topPost")
//    public String toNewPost(Model model){
//        //左边页面显示的内容，查询置顶帖，并展示置顶帖前9条
//        List<Post> post=postService.findAll();
//        model.addAttribute("Post",post);
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }
//
//    //点击“最新”后，重新加载首页，因为首页默认为最新所以链接地址为@{/}
//
//    //点击“首页”后，重新加载首页，所以@{/}
//
//    //点击“精品帖区”，按是否精品帖进行查询，并重新加载页面，并展示查询到的精品贴
//    @GetMapping("/boutiquePost")
//    public String toBoutiquePost(Model model,Map<String,Object> map,@RequestParam(name="page" ,required = false,defaultValue = "1") String pageNumber){
//        int page=Integer.parseInt(pageNumber);
//        //左边页面显示的内容，按是否精品帖进行查询，按时间降序展示
//        List<Post> newPosts=postService.findAllByPostTime(page,6);
//        model.addAttribute("Post",newPosts);
//        //是否为空用于，判断“最新”、“置顶”,用于滚动栏的隐藏判断；具体String用于判断类型
//        map.put("pageButton","newPost");
//
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }
//
//    //点击“需求帖区”，按是否需求帖进行查询，并重新加载页面，并展示查询到的需求贴
//    @GetMapping("/integralPost")
//    public String toIntegralPost(Model model,Map<String,Object> map){
//        //左边页面显示的内容，按是否需求帖进行查询，按时间降序展示
//        List<Post> newPosts=postService.findAllByPostTime(1,5);
//        model.addAttribute("Post",newPosts);
//        //是否为空用于，判断“最新”、“置顶”,用于滚动栏的隐藏判断；具体String用于判断类型
//        map.put("pageButton","newPost");
//
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }
//
//    //点击“人气排行”，来到排行界面
//    @GetMapping("/ranking")
//    public String toRanking(Model model){
//        //左边页面显示的内容，根据……，并查询数据库，展示排行榜
//        List<Post> newPosts=postService.findAllByPostTime(1,6);
//        model.addAttribute("Post",newPosts);
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }
//
//    //点击“积分商城”，来到积分商城界面
//    @GetMapping("/integralMall")
//    public String toIntegralMall(Model model){
//        //左边页面显示的内容，根据……，并查询数据库，来到积分商城
//        List<Post> newPosts=postService.findAllByPostTime(1,6);
//        model.addAttribute("Post",newPosts);
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }
//
//    //点击“type1”，按“type1”进行查询，并重新加载界面，并展示查询到的……帖
//    @GetMapping("/typeOfTJ")
//    public String toTypeOfTJPost(Model model,Map<String,Object> map,@RequestParam(name="page" ,required = false,defaultValue = "1") String pageNumber){
//        //        //左边页面显示的内容，按“type1”进行查询，按时间降序展示
////        List<Post> newPosts=postService.findAllByPostTime(1,6);
////        model.addAttribute("Post",newPosts);
////        //具体String用于判断类型
////        map.put("pageButton","newPost");
//
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }
//    //点击“type2”，按“type2”进行查询，并重新加载界面，并展示查询到的……帖
//    @GetMapping("/typeOfXX")
//    public String toTypeOfXXPost(Model model,Map<String,Object> map,@RequestParam(name="page" ,required = false,defaultValue = "1") String pageNumber){
//        //        //左边页面显示的内容，按“type2”进行查询，按时间降序展示
////        List<Post> newPosts=postService.findAllByPostTime(1,6);
////        model.addAttribute("Post",newPosts);
////        //具体String用于判断类型
////        map.put("pageButton","newPost");
//
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
//        return "index";
//    }
//    //点击“type3”，按“type3”进行查询，并重新加载界面，并展示查询到的……帖
//    @GetMapping("/typeOfYX")
//    public String toTypeOfYXPost(Model model,Map<String,Object> map,@RequestParam(name="page" ,required = false,defaultValue = "1") String pageNumber){
////        //左边页面显示的内容，按“type3”进行查询，按时间降序展示
////        List<Post> newPosts=postService.findAllByPostTime(1,6);
////        model.addAttribute("Post",newPosts);
////        //具体String用于判断类型
////        map.put("pageButton","newPost");
//
//        //右边页面显示的内容，查询浏览量最高的前9条帖子，在本周热议栏展示
//        List<Post> hotMostPost=postService.findAllBypageView(1,9);
//        model.addAttribute("hotPost",hotMostPost);
//        //右边页面显示的内容，查询点赞数最高的前5条帖子，在本周热点栏展示
//        List<Post> popularMostPost=postService.findAllBypageView(1,5);
//        model.addAttribute("popularPost",popularMostPost);
//        //加载首页
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
    //点击搜素按钮,根据输入关键字进行模糊查询；
    @PostMapping("/search")
    public String toSearch(@RequestParam("keyword") String keyword, Model model){
        System.out.println(keyword);
        return "index";
    }
    //规范URL，尝试
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
}
