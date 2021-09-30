package com.jmc.springcloud.controller;

import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

/**
 * @author Example
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/storage")
@Slf4j
public class StorageController {
    private final StorageService storageService;

    @PostMapping("/decrease")
    R decrease(Integer id, Integer orderCount) {
        storageService.decrease(id, orderCount);
        log.info("库存减少了：" + orderCount);
        return R.ok()
                .msg("库存减少了：" + orderCount);
    }
}
