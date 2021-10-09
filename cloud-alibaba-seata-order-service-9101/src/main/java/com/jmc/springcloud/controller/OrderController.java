package com.jmc.springcloud.controller;

import com.jmc.springcloud.pojo.Order;
import com.jmc.net.R;
import com.jmc.springcloud.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jmc
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public R create(Order order) {
        orderService.create(order);
        return R.ok()
                .msg("订单创建完成")
                .data(order);
    }

    @GetMapping("/success")
    public R success() {
        Order order = new Order() {{
            setUserId(1);
            setProductId(1);
            setAmount(10);
            setMoney(100.0);
        }};
        orderService.create(order);

        return R.ok()
                .msg("订单创建完成")
                .data(order);
    }

    /**
     * 可再加一个consumer服务用openfeign正常fallback，返回友好页面
     */
    @GetMapping("/error")
    public R error() {
        Order order = new Order() {{
            setUserId(1);
            setProductId(1);
            setAmount(10);
            setMoney(-100.0);
        }};
        orderService.create(order);

        return R.ok()
                .msg("订单创建完成")
                .data(order);
    }
}
