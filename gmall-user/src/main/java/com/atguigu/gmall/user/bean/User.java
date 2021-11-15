package com.atguigu.gmall.user.bean;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class User {
    private Integer id;
    private String name;
    private String num;

    public User(Integer id, String name, String num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

}
