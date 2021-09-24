package com.jmc.springcloud.controller;

import com.jmc.springcloud.common.Const;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SendMessageController {
    private final StreamBridge bridge;

    @GetMapping("/send")
    public String send() {
        String msg = UUID.randomUUID().toString();
        bridge.send(Const.OUT_BINDING_NAME, msg);
        return msg;
    }
}
