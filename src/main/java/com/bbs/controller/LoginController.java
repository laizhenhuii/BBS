package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Zhenhui Lai
 * @Date 2019/12/13 14:27
 **/
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("telephone") String telephone,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(telephone) && "123".equals(password)){
//            登录成功
            session.setAttribute("loginUser",telephone);
            return "redirect:/index.html";
        }else {
//            登录失败
            map.put("msg","登录信息有误，请重新输入！");
            return "login";
        }
    }
}
