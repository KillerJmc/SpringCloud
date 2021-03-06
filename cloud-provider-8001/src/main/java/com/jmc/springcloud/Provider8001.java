package com.jmc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jmc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Provider8001 {
    public static void main(String[] args) {
        SpringApplication.run(Provider8001.class, args);
    }
}
