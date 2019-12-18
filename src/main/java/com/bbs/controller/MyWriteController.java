package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyWriteController {
    @Autowired
    PostService postService;

    @RequestMapping("/mypost/show")
    public String showPoster(Model model, HttpServletRequest request){
        List<Post> posts=new ArrayList<>();

        posts=postService.findByUserID(request.getSession().getAttribute("tel").toString());
        model.addAttribute("posts",posts);
        return "myWrite";

    }

    @PostMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id){
        postService.deleteByPostID(id);
        return "redirect:/mypost/show";
    }

}
