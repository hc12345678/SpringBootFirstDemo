package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/search")
	public Object search() {
		return userService.search();
	}
	
	@PostMapping("/add")
	public Object add(@RequestBody User u) {
		
		
		return userService.add(u);
		
	}
	
	
	
	
	
}
