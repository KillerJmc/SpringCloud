package com.jmc.springcloud.service;

import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.rest.R;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserFeignService {
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
