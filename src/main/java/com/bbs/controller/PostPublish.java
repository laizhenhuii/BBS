package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.entity.User;
import com.bbs.service.PostService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/*
 * @Description 发表帖子
 * @Author Huang
 * @Date 2019/12/19 10：45
 *  */
@Controller
public class PostPublish {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("/user/writePost")
    /*
     * @Description 点击发新帖，跳转到发帖页面
     * @Author Huang
     * @Date 2019/12/19 10：23
     *  */
    public String writePost(){
        return "write";
    }

    @PostMapping("/savePost")
    /*
     * @Description 将发布的帖子存到数据库，并返回主页面
     * @Author Huang
     * @Date 2019/12/19 10：23
     *  */
    public String savePost(@RequestParam(value = "title",required = false) String title,
                           @RequestParam(value = "text",required = false) String text,
                           @RequestParam(value = "type",required = false) String type,
                           @RequestParam(value = "reward",required = false) int reward,
                           HttpSession session,Map<String,Object>map)throws Exception{

        System.out.println(title + " " + text + " " + type + " "+ reward);

        String posterID=(String)session.getAttribute("tel"); //发帖人ID（手机号）
        int postIntegral=reward;                                //悬赏分

        //首先判断信誉值（小于10点，禁止发贴）
        if(userService.selectByTel(posterID).getReputationValue()<10){
            map.put("msg","‼亲，您的信誉值过低，暂时不能发帖哦~😥");
            return "write";

        }else if(userService.selectByTel(posterID).getIntegral()<reward){
            map.put("msg","⁉亲，积分没那么多，悬赏不到哦~😁");
            return "write";//积分不足
        }else{
           //更新用户积分
            User user=userService.selectByTel(posterID);
            int num=user.getIntegral()-reward;  //临时变量
            user.setIntegral(num);
            int i=userService.updateInformation(user);
//
//            //以下帖子内容初始化
            String posterName=userService.selectByTel(posterID).getName();//发帖人用户名/
            String postTitle=title;//帖子标题
            int mainPost=-1;//是否是主贴，该字段为-1时是主贴
            Timestamp postTime=new Timestamp(new Date().getTime()); //发表时间
            int likeNumber=0;//点赞数
            int pageView=0;//浏览量
            String postContent = text;
            boolean homeTop=false; //是否首页置顶，为true时置顶
            boolean personalTop=false;//是否个人主页置顶，为true时置顶
            boolean postBoutique=false;//是否加精，为true时加精
            String moduleType=type;//版块类型，如天健轶事
            Timestamp lastPost=new Timestamp(new Date().getTime()); //如果该贴是主贴，记录该贴的最后回帖时间
//            String imageAddress=null; //帖子图片地址
//            String postContent = text;

//            //将获取到的帖子信息放到实体类中
            Post post=new Post();
            post.setPosterID(posterID);
            post.setPosterName(posterName);
            post.setPostTitle(postTitle);
            post.setMainPost(mainPost);
            post.setLikeNumber(likeNumber);
            post.setPageView(pageView);
            post.setPostContent(postContent);
            post.setHomeTop(homeTop);
            post.setPostTime(postTime);
            post.setPersonalTop(personalTop);
            post.setPostBoutique(postBoutique);
//            post.setPostIntegral(postIntegral);
            post.setModuleType(moduleType);
//            post.setImageAddress(imageAddress);
            post.setLastPost(lastPost);
//
            postService.addPost(post);          //在数据库中插入新的帖子信息
            return "redirect:/index.html";
        }
    }
}
