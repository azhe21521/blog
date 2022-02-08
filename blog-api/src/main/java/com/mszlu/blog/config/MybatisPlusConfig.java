package com.mszlu.blog.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration/*//对加了@ControllerAdvice的方法进行拦截处理 AOP实现*/
@MapperScan("com.mszlu.blog.dao.mapper")
public class MybatisPlusConfig {


    //Mybatis-plus分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor( new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}
