package com.jmc.springcloud.controller;

import com.jmc.net.R;
import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.service.UserFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
