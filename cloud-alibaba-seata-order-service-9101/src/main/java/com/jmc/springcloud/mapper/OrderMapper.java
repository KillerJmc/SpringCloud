package com.jmc.springcloud.mapper;

import com.jmc.springcloud.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jmc
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
