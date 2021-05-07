package com.yujuncheng.clothing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ClothingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothingApplication.class, args);
    }

}
