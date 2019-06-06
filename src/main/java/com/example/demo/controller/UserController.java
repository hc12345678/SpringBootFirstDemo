package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/search")
	@ResponseBody
	public Object search() {
		return userService.search();
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Object add(@RequestBody User u) {
		return userService.add(u);
	}
	
	
	@GetMapping("/userListPage")
	public String userListPage(Model model) {
		
		model.addAttribute("userList", userService.search());
		
		return "/user/userList";
	}
	
	
	@GetMapping("/userUpdatePage/{id}")
	public String userUpdatePage(Model model,@PathVariable("id") String id) {
		
		model.addAttribute("user", userService.getUserById(id));
		
		return "/user/userUpdate";
	}
	
	
	
	@PostMapping("/saveUser")
	public String saveUser(Model model,@ModelAttribute("user") User user) {
		log.info(user.toString());
		userService.saveUser(user);
		
		
		model.addAttribute("userList", userService.search());
		
		return "/user/userList";
	}
	
	
}
