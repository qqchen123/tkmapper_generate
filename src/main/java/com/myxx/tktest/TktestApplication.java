package com.myxx.tktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.myxx.tktest.mapper")
@SpringBootApplication
public class TktestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TktestApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(TktestApplication.class, args);
    }
}
