package com.atguigu.gmall.user.bean;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import java.util.Date;

@Data
public class UmsMember {

    private Integer id;//
    private Integer member_level_id;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private Integer status;
    private Date create_time;
    private String icon;
    private Integer gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalized_signature;
    private Integer source_type;
    private Integer integration;
    private Integer growth;
    private Integer luckey_count;
    private Integer history_integration;

}
