package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.eunm.BusinessMsEnum;
import com.atguigu.gmall.user.exception.BusinessErrorException;
import com.atguigu.gmall.user.service.RedisService;
import com.atguigu.gmall.user.service.TokenService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    RedisService redisService;
    @Override
    public String createToken() {
        //这个是创建Token
        String str = UUID.randomUUID().toString().replace("-", "");
        StringBuilder token = new StringBuilder();
        try {
            token.append("TOKEN_PREFIX").append(str);
            //写入redis
            redisService.setSessionEX(token.toString(), token.toString(), 10000L);
            boolean empty = StringUtils.isEmpty(token.toString());
            if (!empty) {
                return token.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader("accept-token");
        if(Strings.isEmpty(token)){
            token = request.getParameter("accept-token");
            if(Strings.isEmpty(token)){
                throw new BusinessErrorException(BusinessMsEnum.NOLOGIN_EXCEPTION);
            }
        }
        if(!redisService.exists(token)){
            throw new BusinessErrorException(BusinessMsEnum.NOLOGIN_EXCEPTION);
        }
        boolean remove = redisService.remove(token);

        if(!remove){
            throw new RuntimeException();
        }
        return true;
    }
}
