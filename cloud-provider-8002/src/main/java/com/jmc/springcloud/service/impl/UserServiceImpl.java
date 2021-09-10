package com.jmc.springcloud.service.impl;

import com.jmc.springcloud.dao.UserDao;
import com.jmc.springcloud.pojo.User;
import com.jmc.springcloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userDao.selectById(id);
    }
}
