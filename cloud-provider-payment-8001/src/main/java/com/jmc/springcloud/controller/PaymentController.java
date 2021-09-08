package com.jmc.springcloud.controller;

import com.jmc.springcloud.pojo.Payment;
import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jmc
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/insert")
    public R insert(Payment payment) {
        int res = paymentService.insert(payment);
        log.info("插入结果：" + res);

        if (res > 0) {
            return R.ok()
                    .msg("插入数据库成功")
                    .data(res);
        } else {
            return R.fail()
                    .msg("插入数据库失败");
        }
    }

    @GetMapping("/get/{id}")
    public R getById(@PathVariable Long id) {
        var res = paymentService.getById(id);
        log.info("获取订单：" + res);

        if (res != null) {
            return R.ok()
                    .msg("获取成功")
                    .data(res);
        } else {
            return R.fail()
                    .msg("获取失败");
        }
    }
}
