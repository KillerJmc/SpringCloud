package com.jmc.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Jmc
 */
@Data
@TableName("t_storage")
public class Storage {
    private Integer id;
    private Integer residue;
}
