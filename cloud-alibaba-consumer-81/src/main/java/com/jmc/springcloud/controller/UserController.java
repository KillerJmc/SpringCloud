package com.jmc.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.UserFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
        if (id == 6) throw new RuntimeException();
        return userFeignService.getById(id);
    }
}
