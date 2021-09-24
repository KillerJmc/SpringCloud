package com.jmc.springcloud.service;

import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.rest.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloud-user-service")
public interface UserFeignService {
    @PostMapping("/user/insert")
    R insert(User user);

    /**
     * 注意一定要写value = ""
     */
    @GetMapping("/user/get/{id}")
    R getById(@PathVariable(value = "id") Integer id);
}
