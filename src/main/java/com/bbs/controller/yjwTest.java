package com.bbs.controller;

import com.bbs.entity.Information;
import com.bbs.entity.Post;
import com.bbs.entity.User;
import com.bbs.service.InformationService;
import com.bbs.service.PostService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

//严捷伟Post数据库测试类
//也是数据库接口调用示范类


@RestController
@RequestMapping("/yjwtest")

public class yjwTest {
    @Autowired
    private PostService postService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private UserService userService;

    //帖子数据库接口测试

    //测试成功
    @RequestMapping("Insert")
    public String insert() throws Exception{
        Post post = new Post();
        post.setPostContent("jfkjf");
        post.setHomeTop(true);
        post.setLikeNumber(100);
        post.setMainPost(1);
        post.setModuleType("天健轶事");
        post.setPageView(100);
        post.setPersonalTop(true);
        post.setPostBoutique(true);
        post.setPosterID("18289777366");
        post.setPostTitle("震惊");
        post.setPosterName("皮得很");
        post.setPostTime(new Timestamp(new Date().getTime()));
        post.setPostIntegral(100);
        if(postService.addPost(post) != 0)
            return "插入成功";
        else
            return "插入失败";
    }

    //测试成功
    @RequestMapping("deleteByPostID")
    public String delete(){
        if(postService.deleteByPostID(2) == 1)
            return "删除成功";
        else
            return "删除失败";
    }

    //测试成功
    @RequestMapping("deleteByUserID")
    public String deleteByUserID(){
        if(postService.deleteByUserID("123456") == 1)
            return "删除成功";
        else
            return "删除失败";
    }

    //测试成功
    @RequestMapping("findAll")
    public List<Post> findAll() {
        List<Post> posts = postService.findAll();
        return posts;
    }

    //测试成功
    @RequestMapping("findByUserID")
    public List<Post> findByUserID(){
        return postService.findByUserID("15207972800");
    }

    //测试成功
    @RequestMapping("findByPostID")
    public Post findByPostID(){
        return postService.findByPostID(1);
    }



    @RequestMapping("findByPageType1")
    public List<Post> findByPageType1(){
        return postService.findAllByPage(1, 1, 5);
    }

    @RequestMapping("findByPageType2")
    public List<Post> findByPageType2(){
        return postService.findAllByPage(2, 1, 5);
    }

    @RequestMapping("findByPageType3")
    public List<Post> findByPageType3(){
        return postService.findAllByPage(3, 1, 5);
    }

    @RequestMapping("findByPageType4")
    public List<Post> findByPageType4(){
        return postService.findAllByPage(4, 1, 5);
    }
    @RequestMapping("findByPageType5")
    public List<Post> findByPageType5(){
        return postService.findAllByPage(5, 1, 5);
    }
    @RequestMapping("findByPageType6")
    public List<Post> findByPageType6(){
        return postService.findAllByPage(6, 1, 5);
    }
    @RequestMapping("findByPageType7")
    public List<Post> findByPageType7(){
        return postService.findAllByPage(7, 1, 5);
    }
    @RequestMapping("findByPageType8")
    public List<Post> findByPageType8(){
        return postService.findAllByPage(8, 1, 5);
    }
    @RequestMapping("findByPageType9")
    public List<Post> findByPageType9(){
        return postService.findAllByPage(9, 1, 5);
    }

    @RequestMapping("findLikePostTitle")
    public List<Post> findLikePostTitle(){
        return postService.findLikePostTitle("震惊");
    }



    //测试成功
    @RequestMapping("update")
    public String updateByPostID(){
        Post post = postService.findByPostID(4);
        if(post == null)
            return "修改失败";
        post.setPostContent("jfkjf");
        post.setHomeTop(true);
        post.setLikeNumber(100);
        post.setMainPost(1);
        post.setModuleType("休闲轶事");
        post.setPageView(100);
        post.setPersonalTop(true);
        post.setPostBoutique(true);
        post.setPosterID("17366");
        post.setPostTitle("震惊");
        post.setPosterName("皮得很");
        post.setPostTime(new Timestamp(new Date().getTime()));
        if(postService.updatePost(post)!= 0)
            return "修改成功";
        else
            return "修改失败";
    }

    //消息数据库接口测试

    @RequestMapping("informationInsert")
    public String informationInsert(){
        Information information = new Information();
        information.setOriginContent("震惊，南昌大学先啸园出现眼镜蛇");
        information.setReceiverTel("15207972800");
        information.setPostTime(new Timestamp(new Date().getTime()));
        information.setOriginTitle("震惊，南昌大学先啸园出现眼镜蛇");
        information.setHaveRead(false);
        if(informationService.addInformation(information) != 0)
            return "插入成功";
        else
            return "插入失败";
    }

    @RequestMapping("deleteByInformationID")
    public String deleteByInformationID(){
        if(informationService.findByInformationID(2) == null)
            return "删除失败";
        if(informationService.deleteByInformationID(2) != 0)
            return "删除成功";
        else
            return "删除失败";

    }

    @RequestMapping("deleteByReceiverTel")
    public String deleteByReceiverTel(){
        if(informationService.findByReceiverTel("15207972800") == null)
            return "删除失败";
        if(informationService.deleteByUserID("15207972800") != 0)
            return "删除成功";
        else
            return "删除失败";
    }

    @RequestMapping("findAllInformation")
    public List<Information> findAllInformation(){
        return informationService.findAll();
    }

    @RequestMapping("findByReceiverTel")
    public List<Information> findByReceiverTel(){
        return informationService.findByReceiverTel("15207972800");
    }

    @RequestMapping("findUserLikeName")
    //用户数据库接口测试
    public List<User> findUserLikeName(){
        return userService.findLikeUserName("开心");
    }

}
