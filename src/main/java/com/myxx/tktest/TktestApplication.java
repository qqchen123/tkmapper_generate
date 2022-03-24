package com.myxx.tktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.myxx.tktest.mapper")
@SpringBootApplication
public class TktestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TktestApplication.class, args);
    }
}
