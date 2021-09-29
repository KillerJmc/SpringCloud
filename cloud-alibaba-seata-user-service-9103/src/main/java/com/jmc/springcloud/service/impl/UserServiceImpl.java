package com.jmc.springcloud.service.impl;

import com.jmc.springcloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.jmc.springcloud.mapper.UserMapper;

/**
 * @author Example
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper storageMapper;

    @Override
    public void consumer(Integer userId, Double money) {
        storageMapper.consumer(userId, money);
    }
}
