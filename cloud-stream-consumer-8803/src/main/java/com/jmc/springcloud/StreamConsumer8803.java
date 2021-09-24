package com.jmc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jmc
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8803.class, args);
    }
}
