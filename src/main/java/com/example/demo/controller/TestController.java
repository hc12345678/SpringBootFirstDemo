package com.example.demo.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("user")
public class TestController {
//
//	@GetMapping("/hello")
//	@ResponseBody
	public String hello() {
		
		System.out.println(new Random().nextInt(8)+1);
		
		
		
		return "hello world";
	}
	
	
	
	
	
}
