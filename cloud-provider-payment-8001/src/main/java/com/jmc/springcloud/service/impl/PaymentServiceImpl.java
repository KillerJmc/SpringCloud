package com.jmc.springcloud.service.impl;

import com.jmc.springcloud.dao.PaymentDao;
import com.jmc.springcloud.pojo.Payment;
import com.jmc.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        payment.setId(paymentDao.selectCount(null) + 1L);
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.selectById(id);
    }
}
