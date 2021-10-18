package com.example.shop_buyer_web.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author tai
 * @date: 2021-09-14 15:05
 * @description:
 */
@Controller
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图跳转ViewController
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问/showLogin时跳转到login视图
        registry.addViewController("/buyer/toLogin").setViewName("login");
    }



    /**
     * 配置静态资源映射
     * */
    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry){
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
