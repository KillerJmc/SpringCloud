package com.jmc.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmc.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jmc
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
    int insert(Payment payment);
}
