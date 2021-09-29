package com.jmc.springcloud.controller;

import com.jmc.springcloud.mapper.OrderMapper;
import com.jmc.springcloud.pojo.Order;
import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.StorageService;
import com.jmc.springcloud.service.UserService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.jmc.springcloud.service.OrderService;

/**
 * @author Jmc
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/create")
    public R create(Order order) {
        orderService.create(order);
        return R.ok()
                .msg("订单创建完成")
                .data(order);
    }
}
