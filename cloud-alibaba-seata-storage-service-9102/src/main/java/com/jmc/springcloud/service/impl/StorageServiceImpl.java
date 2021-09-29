package com.jmc.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.jmc.springcloud.pojo.Storage;
import com.jmc.springcloud.rest.R;
import com.jmc.springcloud.service.StorageService;
import com.jmc.springcloud.mapper.StorageMapper;
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
    public void decrease(Integer productId, Integer orderCount) {
        storageMapper.decrease(productId, orderCount);
    }
}
