package com.jmc.springcloud.service;

/**
 * @author Jmc
 */
public interface StorageService {
    void decrease(Integer id, Integer orderCount);
}
