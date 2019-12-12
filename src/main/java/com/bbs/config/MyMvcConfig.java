package com.bbs.config;

import com.bbs.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
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
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
    }

    @Bean //向容器中添加组件
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
