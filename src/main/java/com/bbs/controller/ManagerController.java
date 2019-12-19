package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manages")
public class ManagerController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    //帖子页
    @RequestMapping("/postTable")
    public String postTable(Map<String, Object> mp){
        mp.put("post", postService.findAll());
        return "postTable";
    }

    //用户页
    @RequestMapping("/userTable")
    public String userTable(Map<String, Object> mp){
        mp.put("Users", userService.selectAll());
        return "userTable";
    }

}
