package com.jmc.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Example
 */
@Data
@TableName("t_user")
public class User {
    private Integer id;
    private Integer balance;
}
