package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.common.page.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.common.HttpResp;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> search() {
		// TODO Auto-generated method stub
		return userDao.search(null);
	}

	@Override
	public HttpResp add(User u) {
//		u.setId(UUID.randomUUID().toString().replace("-", ""));
		int num = userDao.add(u);


		HttpResp hrp = new HttpResp();
		
		if(num==1) {
			hrp.setCode("100300");
			hrp.setMsg("访问成功");
			hrp.setContent(u);
		}else {
			hrp.setCode("100200");
			hrp.setMsg("访问失败");
			hrp.setContent(null);
		}
		
		return hrp;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

	@Override
	public User login(User u) {
		return userDao.login(u);
	}

	@Override
	public PageInfo<User> getUserByPage(Page page,User u) {

		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<User> users=userDao.search(u);
		PageInfo<User> pageInfo = new PageInfo<User>(users);


		return pageInfo;
	}

}
