package com.jmc.springcloud.controller;

import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.UserFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserFeignService userFeignService;

    @GetMapping("/insert")
    public R insert(User user) {
        return userFeignService.insert(user);
    }

    @GetMapping("/get/{id}")
    public R getById(@PathVariable Integer id) {
        return userFeignService.getById(id);
    }
}
