package com.example.demo.controller;

import com.example.demo.common.HttpResp;
import com.example.demo.common.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public Object user(@RequestBody User user) throws Exception {


        User u = userService.login(user);
        if(u!=null){ //登录成功的情况
            return HttpResp.success(JwtUtil.sign(u.getUserName(),u.getPassword()));
        }else{
            return HttpResp.fail();
        }
//        throw new  Exception();

    }


}
