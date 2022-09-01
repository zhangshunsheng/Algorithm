package com.example.demo_practise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo.practise.mapper")
@SpringBootApplication
public class DemoPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoPractiseApplication.class, args);
    }

}
