package com.jmc.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmc.springcloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jmc
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
