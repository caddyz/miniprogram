package com.miaoyidj.miniprogram.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusConfig
 * @Description TODO 分页插件
 * @Author Kaiser
 * @Date 2019/7/7 11:35
 * @Version 1.0
 **/
@Configuration
@MapperScan("com.miaoyidj.miniprogram.mapper*")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
