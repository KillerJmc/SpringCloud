package com.jmc.springcloud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.jmc.springcloud.rest.R;

@RestController
@RequestMapping("/consumer/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @GetMapping("/insert")
    public R insert(String serial) {
        return restTemplate.postForObject(PAYMENT_URL + "/insert?serial=" + serial, null, R.class);
    }

    @GetMapping("/get/{id}")
    public R getById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/get/" + id, R.class);
    }
}
