package com.jmc.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Jmc
 */
@Data
@TableName("t_user")
public class User {
    private Integer id;
    private Integer balance;
}
