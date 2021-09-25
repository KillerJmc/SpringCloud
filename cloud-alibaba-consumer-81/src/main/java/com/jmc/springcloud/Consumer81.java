package com.jmc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Consumer81 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer81.class, args);
    }
}
