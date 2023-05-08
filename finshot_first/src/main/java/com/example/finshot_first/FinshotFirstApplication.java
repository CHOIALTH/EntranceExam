package com.example.finshot_first;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.finshot_first.mapper")
public class FinshotFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinshotFirstApplication.class, args);
    }

}
