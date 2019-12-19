package com.bbs.controller;

import com.bbs.entity.User;
import com.bbs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Zhenhui Lai
 * @Date 2019/12/13 14:27
 **/
@Controller
public class LoginController {
    final
    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public  String register(@RequestParam("username") String username,
                            @RequestParam("telephone") String telephone,
                            @RequestParam("password") String password,
                            Map<String,Object> map){
        if (userService.registerUser(username, telephone,password,new Timestamp((new Date().getTime())))){
            return "login";
        }else {
            map.put("msg","亲！您已经注册过了，快去登录吧！");
            return "register";
        }
    }

    @PostMapping("/user/login")
    public String login(@RequestParam("telephone") String telephone,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (telephone == " "){
//            输入不合法，手机号为空
            map.put("msg","亲！请不要输入空手机号哦");
            return "login";
        }else if(userService.login(telephone,password) == 1){
//            登录成功
            session.setAttribute("username",userService.selectByTel(telephone).getName());
            session.setAttribute("tel",telephone);
            return "index";
        }else if (userService.login(telephone,password) == 0){
//            手机号不存在
            map.put("msg","未找到您的账户，请先注册或检查手机号是否输入正确");
            return "login";
        }else {
//            密码错误
            map.put("msg","您输入的密码错误喔！请重新输入。");
            return "login";
        }
    }
}
