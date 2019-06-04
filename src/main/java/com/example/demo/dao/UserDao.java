package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

@Mapper
public interface UserDao {

	
	
	
	@Select("select * from user")
	List<User> search();
	
	
	@Insert("insert into user values(#{id},#{userName},#{password})")
	int add(User u);
	
	
	
	
}
