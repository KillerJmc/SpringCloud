package com.jmc.springcloud.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
