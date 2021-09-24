package com.jmc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Consumer<String> receive() {
        return s -> log.info(serverPort + ": " + s);
    }
}
