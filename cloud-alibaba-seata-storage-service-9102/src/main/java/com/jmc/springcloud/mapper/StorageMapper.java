package com.jmc.springcloud.mapper;

import com.jmc.springcloud.pojo.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmc.springcloud.rest.R;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author Example
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    @Update("update t_storage set residue = residue - #{arg1} where product_id = #{arg0}")
    void decrease( Integer productId, Integer orderCount);
}
