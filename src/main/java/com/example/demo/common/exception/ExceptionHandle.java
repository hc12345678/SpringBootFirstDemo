package com.example.demo.common.exception;


import com.example.demo.common.HttpResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResp handleEx(Exception e){
        HttpResp rp = new HttpResp();
        if(e instanceof UnauthorizedException){
            rp.setContent(null);
            rp.setMsg("没有权限");
            rp.setCode("401");
            return rp;
        }else {
            rp.setCode("500");
            rp.setMsg("服务器开小差了");
            rp.setContent(null);
            return rp;
        }

    }
}
