package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author Zhenhui Lai
 * @Date 2019/12/13 19:04
 **/
@Controller
public class IndexController {

    @GetMapping("/index/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
