package com.bbs.controller;

import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/user/home")
    public String home(HttpSession session, Map<String,Object> map){
        String tel = (String)session.getAttribute("tel");
        map.put("username",userService.selectByTel(tel).getName());
        map.put("sex",userService.selectByTel(tel).getSex());
        if(map.get("sex")==null)
            map.put("sex","未知性别");
        map.put("email",userService.selectByTel(tel).getEmail());
        if(map.get("email")==null)
            map.put("email","未填写邮箱");
        map.put("sign",userService.selectByTel(tel).getSign());
        if(map.get("sign")==null)
            map.put("sign","未设置个性签名");
        map.put("studyArea",userService.selectByTel(tel).getStudyArea());
        if(map.get("studyArea")==null)
            map.put("studyArea","未选择学区");
        map.put("home",userService.selectByTel(tel).getHome());
        if(map.get("home")==null)
            map.put("home","未填写家乡");
        map.put("registerTime",userService.selectByTel(tel).getRegisterTime());
        map.put("birthday",userService.selectByTel(tel).getBirthday());
        if(map.get("birthday")==null)
            map.put("birthday","未选择生日");
        return "home";
    }

    @RequestMapping("/user/base")
    public String base(HttpSession session,Map<String,Object> map){
//        map.put("username",userService.selectByTel("1").getName());
        return "base";
    }

    @RequestMapping("/user/myWrite")
    public String tiezi(){
        return "myWrite";
    }

    @RequestMapping("/user/myMsg")
    public String myMsg(){
        return "myMsg";
    }
}
