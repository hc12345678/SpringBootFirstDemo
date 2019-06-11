package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("user")
@Slf4j
@CrossOrigin
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

	@GetMapping("/getUserById/{id}")
	@ResponseBody
	public Object getUserById(@PathVariable("id") String id) {



		return userService.getUserById(id);
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


	@PostMapping("/saveUser2")
	@ResponseBody
	public Object saveUser(@RequestBody User user) {
		log.info(user.toString());
		userService.saveUser(user);



		return "success";
	}
	
	
}
