package com.jmc.springcloud.service;

import com.jmc.springcloud.rest.R;

/**
 * @author Example
 */
public interface StorageService {
    void decrease(Integer productId, Integer orderCount);
}
