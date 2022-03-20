package com.jmc.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmc.springcloud.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author Jmc
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    @Update("update t_storage set residue = residue - #{arg1} where id = #{arg0}")
    void decrease(Integer id, Integer orderCount);
}
