package com.bbs.controller;

import com.bbs.entity.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author Zhenhui Lai
 * @Date 2019/12/13 19:04
 **/
@Controller
public class IndexController {

    final
    UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/index")
    public String index(){
        return "index";
    }


    @GetMapping("/user/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
