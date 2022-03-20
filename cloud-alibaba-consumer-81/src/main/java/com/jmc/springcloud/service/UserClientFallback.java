package com.jmc.springcloud.service;

import com.jmc.net.R;
import com.jmc.springcloud.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public R insert(User user) {
        return R.error()
                .msg("fallback: 插入失败")
                .data(user);
    }

    @Override
    public R getById(Integer id) {
        return R.error()
                .msg("fallback: 获取失败")
                .data("id = " + id);
    }
}
