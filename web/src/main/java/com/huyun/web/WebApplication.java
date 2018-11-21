package com.huyun.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan(basePackages = "com.huyun.*.dao")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//屏蔽自带数据源自动加载
@SpringBootApplication(scanBasePackages="com.huyun")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
