package com.example.demo.service;

import java.util.List;

import com.example.demo.common.HttpResp;
import com.example.demo.model.User;

public interface UserService {

	
	
	
	List<User> search();
	
	HttpResp add(User u);
	
	User getUserById(String id);

	void saveUser(User user);
	
}
