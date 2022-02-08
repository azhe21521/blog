package com.mszlu.blog.config;

import com.mszlu.blog.Handle.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMmvConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    //做跨域配置，为什么要做这个跨域的配置呢，因为比如：我前端的端口号是8080，而我后端接口是8888
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //addMapping就是所有的文件，allowedOrigins指的是可以那个地址可以访问
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截接口
//        除了登录注册的所有接口
       registry.addInterceptor(loginInterceptor)
               .addPathPatterns("/**")
               .excludePathPatterns("/login").excludePathPatterns("/register");
//      registry.addInterceptor(loginInterceptor)
//              .addPathPatterns("/test");
    }
}
