package com.atguigu.gmall.user.service;


import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/*拓展redis*/

public interface TokenService {
    /*
    * 创建token
    * */
    public String createToken();
    /*
    * 校验token
    * */
    public boolean checkToken(HttpServletRequest httpServletRequest);
}
