package com.jmc.springcloud.service.impl;

import com.jmc.springcloud.mapper.UserMapper;
import com.jmc.springcloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jmc
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public void consumer(Integer id, Double money) {
        userMapper.consumer(id, money);
    }
}
