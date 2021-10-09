package com.jmc.springcloud.service.impl;

import com.jmc.springcloud.mapper.StorageMapper;
import com.jmc.springcloud.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Example
 */
@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {
    private final StorageMapper storageMapper;

    @Override
    public void decrease(Integer id, Integer orderCount) {
        storageMapper.decrease(id, orderCount);
    }
}
