package com.bbs.controller;

import com.bbs.entity.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
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
        User user = userService.selectByTel((String)session.getAttribute("tel"));
        map.put("username",user.getName());
        map.put("sex",user.getSex());
        if(map.get("sex")==null)
            map.put("sex","未知性别");
        map.put("email",user.getEmail());
        if(map.get("email")==null)
            map.put("email","未填写邮箱");
        map.put("sign",user.getSign());
        if(map.get("sign")==null)
            map.put("sign","未设置个性签名");
        map.put("studyArea",user.getStudyArea());
        if(map.get("studyArea")==null)
            map.put("studyArea","未选择学区");
        map.put("home",user.getHome());
        if(map.get("home")==null)
            map.put("home","未填写家乡");
        map.put("registerTime",user.getRegisterTime());
        map.put("integral",user.getIntegral());
        map.put("reputationValue",user.getReputationValue());
        map.put("birthday",user.getBirthday());
        if(map.get("birthday")==null)
            map.put("birthday","未选择生日");
        return "home";
    }

    @RequestMapping("/user/base")
    public String base(HttpSession session,Map<String,Object> map){
        User user = userService.selectByTel((String)session.getAttribute("tel"));
        String tel = (String)session.getAttribute("tel");
        map.put("username",user.getName());
        map.put("email",userService.selectByTel(tel).getEmail());
        if(map.get("email")==null)
            map.put("email","未填写邮箱");
        map.put("sign",userService.selectByTel(tel).getSign());
        if(map.get("sign")==null)
            map.put("sign","未设置个性签名");
        map.put("studyArea",userService.selectByTel(tel).getStudyArea());
        if(map.get("home")==null)
            map.put("home","未填写家乡");
        map.put("birthday",userService.selectByTel(tel).getBirthday());
        if(map.get("birthday")==null)
            map.put("birthday","未选择生日");
        return "base";
    }

    @RequestMapping("/user/change")
    public String change(@RequestParam("username") String username,
                         @RequestParam("sex") String sex,
                         @RequestParam("email") String email,
                         @RequestParam("sign") String sign,
                         @RequestParam("studyArea") String studyArea,
//                         @RequestParam("birthday") Timestamp birthday,
                         @RequestParam("home") String home,
                         HttpSession session){
        User user = userService.selectByTel((String) session.getAttribute("tel"));
        user.setName(username);
        session.setAttribute("username",username);
        user.setSex(sex);
        user.setEmail(email);
        if (!sign.isEmpty())
            user.setSign(sign);
        if(!studyArea.isEmpty())
            user.setStudyArea(studyArea);
        if(!home.isEmpty())
            user.setHome(home);
//        user.setBirthday( birthday==null?null:birthday);
//        System.out.println(birthday);
        userService.updateInformation(user);
        return "base";
    }

    @RequestMapping("/user/Password")
    public String Password(){
        return "upload_password";
    }

    @RequestMapping("/user/changePassword")
    public String changePassword(@RequestParam("old") String old,
                                 @RequestParam("new1") String new1,
                                 @RequestParam("new2") String new2,
                                 Map<String,Object> map,
                                 HttpSession session){
        User user = userService.selectByTel((String) session.getAttribute("tel"));
        if(!old.equals(user.getPassword())){
            map.put("msg","原输入密码错误！请重新输入！");
        } else if(!new1.equals(new2)){
            map.put("msg","两次密码不一致！请重新输入！");
        }else {
            map.put("msg","修改密码成功！");
            user.setPassword(new1);
            userService.updateInformation(user);
        }
        return "upload_password";
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
