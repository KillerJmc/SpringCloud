package com.jmc.springcloud.service;

import com.jmc.springcloud.pojo.User;

/**
 * @author Jmc
 */
public interface UserService {
    int insert(User user);
    User getById(Integer id);
}
