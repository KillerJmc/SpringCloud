package com.jmc.springcloud.service;

import com.jmc.net.R;
import com.jmc.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "cloud-user-service", path = "/user")
public interface UserFeignService {
    @PostMapping("/insert")
    R insert(User user);

    /**
     * 注意一定要写value = ""
     */
    @GetMapping("/get/{id}")
    R getById(@PathVariable(value = "id") Integer id);
}
