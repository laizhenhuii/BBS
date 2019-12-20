package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.entity.User;
import com.bbs.service.PostService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("/administrator/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "login";
    }

    //用户页
    @RequestMapping("/administrator/userTable")
    public String userTable(Map<String, Object> map,HttpSession session){
        map.put("users", userService.selectAll());
        return "administrator";
    }

    @RequestMapping(value = "/administrator/warning",method = RequestMethod.GET)
    public String warning(Model model, HttpServletRequest request){
        String tel = request.getParameter("tel");
        User user = userService.selectByTel(tel);
        user.setReputationValue(user.getReputationValue()-10);
        user.setIntegral(user.getIntegral()-50);
        if(user.getReputationValue() < 0)
            user.setReputationValue(0);
        if(user.getIntegral()<0)
            user.setIntegral(0);
        userService.updateInformation(user);
        return "redirect:/administrator/userTable";
    }

    @RequestMapping(value = "/administrator/ban",method = RequestMethod.GET)
    public String ban(HttpServletRequest request){
        String tel = request.getParameter("tel");
        User user = userService.selectByTel(tel);
        user.setReputationValue(0);
        user.setIntegral(user.getIntegral()-100);
        if(user.getIntegral()<0)
            user.setIntegral(0);
        userService.updateInformation(user);
        return "redirect:/administrator/userTable";
    }

    @RequestMapping(value = "/administrator/del",method = RequestMethod.GET)
    public String del(HttpServletRequest request){
        String tel = request.getParameter("tel");
        userService.deleteUser(tel);
        return "redirect:/administrator/userTable";
    }

    //帖子页
    @RequestMapping("/administrator/postTable")
    public String postTable(Map<String, Object> map){
        map.put("posts", postService.findAllByPage(1,1,10));
        return "administratorPost";
    }

    @RequestMapping(value = "/administrator/top",method = RequestMethod.GET)
    public String top(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        Post post = postService.findByPostID(id);
        post.setHomeTop(true);
        postService.updatePost(post);
        return  "redirect:/administrator/postTable";
    }

    @RequestMapping(value = "/administrator/essence",method = RequestMethod.GET)
    public String essence(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        Post post = postService.findByPostID(id);
        post.setPostBoutique(true);
        postService.updatePost(post);
        return  "redirect:/administrator/postTable";
    }

    @RequestMapping(value = "/administrator/cleartop",method = RequestMethod.GET)
    public String cleartop(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        Post post = postService.findByPostID(id);
        post.setHomeTop(false);
        postService.updatePost(post);
        return  "redirect:/administrator/postTable";
    }

    @RequestMapping(value = "/administrator/clearessence",method = RequestMethod.GET)
    public String clearessence(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        Post post = postService.findByPostID(id);
        post.setPostBoutique(false);
        postService.updatePost(post);
        return  "redirect:/administrator/postTable";
    }

    @RequestMapping(value = "/administrator/postdel",method = RequestMethod.GET)
    public String postdel(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        postService.deleteByPostID(id);
        return  "redirect:/administrator/postTable";
    }

}
