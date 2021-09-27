package com.jmc.springcloud.service;

import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.UserFeignService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserFeignService {
    @Override
    public R insert(User user) {
        return R.fail()
                .msg("fallback: 插入失败")
                .data(user);
    }

    @Override
    public R getById(Integer id) {
        return R.fail()
                .msg("fallback: 获取失败")
                .data("id = " + id);
    }
}
