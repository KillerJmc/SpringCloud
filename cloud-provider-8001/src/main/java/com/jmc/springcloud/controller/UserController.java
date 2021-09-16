package com.jmc.springcloud.controller;

import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author Jmc
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/insert")
    public R insert(@RequestBody User user) {
        int res = userService.insert(user);
        log.info("插入结果：" + res);

        if (res > 0) {
            return R.ok()
                    .msg("插入数据库成功，端口号：" + serverPort)
                    .data(res);
        } else {
            return R.fail()
                    .msg("插入数据库失败，端口号：" + serverPort);
        }
    }

    @GetMapping("/get/{id}")
    public R getById(@PathVariable Integer id) {
        var res = userService.getById(id);
        log.info("获取用户：" + res);

        if (res != null) {
            return R.ok()
                    .msg("获取成功，端口号：" + serverPort)
                    .data(res);
        } else {
            return R.fail()
                    .msg("获取失败，端口号：" + serverPort);
        }
    }

    @GetMapping("/hystrix/ok")
    public String hystrixOk() {
        return "线程名称: " + Thread.currentThread().getName() + ", OK!";
    }

    @GetMapping("/hystrix/timeout")
    public String hystrixTimeout() throws InterruptedException {
        int delaySecs = 3;
        TimeUnit.SECONDS.sleep(delaySecs);
        return "线程名称: " + Thread.currentThread().getName()
                + ", 耗时" + delaySecs + "秒!";
    }
}
