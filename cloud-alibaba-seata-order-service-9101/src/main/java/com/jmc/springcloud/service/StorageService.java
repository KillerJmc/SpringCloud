package com.jmc.springcloud.service;

import com.jmc.net.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jmc
 */
@FeignClient(value = "storage-service", path = "/storage")
public interface StorageService {
    @PostMapping("/decrease")
    R decrease(@RequestParam("id") Integer id, @RequestParam("orderCount") Integer orderCount);
}
