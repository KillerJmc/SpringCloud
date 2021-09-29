package com.jmc.springcloud.service.impl;

import com.jmc.springcloud.pojo.Order;
import com.jmc.springcloud.service.OrderService;
import com.jmc.springcloud.mapper.OrderMapper;
import com.jmc.springcloud.service.StorageService;
import com.jmc.springcloud.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jmc
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final StorageService storageService;
    private final UserService userService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("订单服务：开始创建订单");
        orderMapper.insert(order);

        log.info("订单服务 -> 库存服务: 减少库存");
        storageService.decrease(order.getProductId(), order.getAmount());

        log.info("订单服务 -> 账户服务: 消费金额");
        userService.consume(order.getUserId(), order.getMoney());

        log.info("订单服务：成功创建订单！");
    }
}
