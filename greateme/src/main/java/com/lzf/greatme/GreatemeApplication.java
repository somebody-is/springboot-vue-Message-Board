package com.lzf.greatme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.lzf.greatme")
@MapperScan("com.lzf.greatme.mapper")
public class GreatemeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreatemeApplication.class, args);
    }

}
