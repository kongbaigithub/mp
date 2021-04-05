package com.hxl.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxl.mp.order.mapper")
public class Application {


    public static void main(String[] args) throws Exception {
    		SpringApplication.run(Application.class, args);
    	}
}
