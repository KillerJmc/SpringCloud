package com.jmc.springcloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.UserService;

import java.util.concurrent.TimeUnit;

/**
 * @author Example
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/consume")
    R consume(Integer userId, Double money) {
        // 模拟支付异常
        if (money < 0) {
            throw new RuntimeException("金额错误！");
        }

        userService.consumer(userId, money);
        log.info("用户支付金额：" + money);
        return R.ok()
                .msg("用户支付金额：" + money);
    }
}
