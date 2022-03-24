//package com.myxx.tktest.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tk.mybatis.spring.mapper.MapperScannerConfigurer;
//
//import java.util.Properties;
//
///**
// *
// */
//@Configuration
//public class IdConfig {
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.myxx.tktest.mapper");
//        Properties propertiesMapper = new Properties();
//        // 通用mapper位置，不要和其他mapper、dao放在同一个目录
//        propertiesMapper.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
//        propertiesMapper.setProperty("notEmpty", "true");
//        // 主键UUID回写方法执行顺序,默认AFTER,可选值为(BEFORE|AFTER)
//        propertiesMapper.setProperty("ORDER", "BEFORE");
//        mapperScannerConfigurer.setProperties(propertiesMapper);
//        return mapperScannerConfigurer;
//    }
//}
