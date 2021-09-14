package com.example.zsmes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zsmes.mapper")
public class ZsmesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsmesApplication.class, args);
    }

}
