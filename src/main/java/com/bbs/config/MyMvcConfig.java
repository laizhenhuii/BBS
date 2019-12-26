package com.bbs.config;

import com.bbs.component.LoginHandlerInterceptor;
import com.bbs.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @ClassName MyMvcConfig
 * @Description TODO
 * @Author Zhenhui Lai
 * @Date 2019/12/11 10:56
 **/
@Configuration
public class MyMvcConfig implements  WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images");
        String path = "C:\\Users\\75812\\OneDrive\\作业\\大三上\\web程序设计\\期末大作业 (1)\\bbs\\BBS\\src\\main\\resources\\static\\images\\";
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + path);
    }

//    地址映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/common.html").setViewName("common");
        registry.addViewController("/home.html").setViewName("home");
        registry.addViewController("/base.html").setViewName("base");
        registry.addViewController("/upload_password.html").setViewName("upload_password");
        registry.addViewController("/myWrite.html").setViewName("myWrite");
        registry.addViewController("/tiezi.html").setViewName("tiezi");
        registry.addViewController("/changeContent.html").setViewName("changeContent");
        registry.addViewController("/mytiezi.html").setViewName("mytiezi");
        registry.addViewController("/administrator.html").setViewName("administrator");
        registry.addViewController("/administratorPost.html").setViewName("administratorPost");
        registry.addViewController("/myMsg.html").setViewName("myMsg");
    }

//    拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/webjars/**","/asserts/**","/","/index.html",
                        "/register.html","/login.html","/user/login","/user/register","/user/index","/toPost","/search","/index/exit","/writeComment","/images/**");
    }

    @Bean //向容器中添加组件
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
