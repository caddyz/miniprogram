package com.miaoyidj.miniprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"com.miaoyidj.miniprogram.config",
        "com.miaoyidj.miniprogram.controller",
        "com.miaoyidj.miniprogram.service"})
public class MiniprogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniprogramApplication.class, args);
    }

}
