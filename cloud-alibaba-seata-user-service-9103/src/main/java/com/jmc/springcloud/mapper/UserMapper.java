package com.jmc.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jmc.springcloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author Example
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update t_user set balance = balance - #{arg1} where id = #{arg0}")
    void consumer(Integer id, Double money);
}
