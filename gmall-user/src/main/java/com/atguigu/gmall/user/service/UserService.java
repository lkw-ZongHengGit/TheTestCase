package com.atguigu.gmall.user.service;

import com.atguigu.gmall.user.bean.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;

@Service
public interface UserService {

    String getUser();

    List<UmsMember> getAllUser();
}
