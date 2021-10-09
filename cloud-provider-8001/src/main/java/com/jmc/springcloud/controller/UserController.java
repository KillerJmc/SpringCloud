package com.jmc.springcloud.controller;

import com.jmc.net.R;
import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jmc
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
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
            throw new NullPointerException();
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
            throw new NullPointerException();
        }
    }
}
