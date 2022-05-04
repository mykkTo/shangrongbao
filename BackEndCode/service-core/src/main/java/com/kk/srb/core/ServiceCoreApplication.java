package com.kk.srb.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.kk.srb.core.mapper"})// 需要指定指定路径
public class ServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run (ServiceCoreApplication.class, args);
    }
}
