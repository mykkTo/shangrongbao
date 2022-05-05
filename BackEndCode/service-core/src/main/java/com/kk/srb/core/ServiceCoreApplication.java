package com.kk.srb.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan({"com.kk.srb"})// 需要指定指定路径
@ComponentScan({"com.kk.srb","com.kk.common"})
public class ServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run (ServiceCoreApplication.class, args);
    }
}
