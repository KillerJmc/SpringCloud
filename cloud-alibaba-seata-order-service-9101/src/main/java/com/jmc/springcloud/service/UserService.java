package com.jmc.springcloud.service;

import com.jmc.springcloud.rest.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jmc
 */
@FeignClient(value = "user-service", path = "/user")
public interface UserService {
    @PostMapping("/consume")
    R consume(@RequestParam("id") Integer id, @RequestParam("money") Double money);
}
