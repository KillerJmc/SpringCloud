package com.jmc.springcloud.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String password;
}
