package com.kk.srb.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.kk.srb"})
public class ServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run (ServiceCoreApplication.class, args);
    }
}
