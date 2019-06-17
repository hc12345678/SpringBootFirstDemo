package com.example.demo.service;

import java.util.List;

import com.example.demo.common.HttpResp;
import com.example.demo.common.page.Page;
import com.example.demo.model.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

	
	
	
	List<User> search();
	
	HttpResp add(User u);
	
	User getUserById(String id);

	void saveUser(User user);

	User login(User u);

	PageInfo<User> getUserByPage(Page page,User u);

}
