package com.jmc.springcloud.service;

import com.jmc.springcloud.pojo.Payment;

/**
 * @author Jmc
 */
public interface PaymentService {
    int insert(Payment payment);
    Payment getById(Long id);
}
