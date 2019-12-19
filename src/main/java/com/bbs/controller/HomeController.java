package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author Zhenhui Lai
 * @Date 2019/12/18 19:54
 **/
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @RequestMapping("/user/base")
    public String home(HttpSession session,Map<String,Object> map){
//        map.put("username",userService.selectByTel("1").getName());
        return "base";
    }

 //   @RequestMapping("/user/tiezi")
 //   public String showPoster(Model model, HttpServletRequest request){

 //       return "myWrite";

   // }

    @RequestMapping("/user/myMsg")
    public String myMsg(){
        return "myMsg";
    }
}
