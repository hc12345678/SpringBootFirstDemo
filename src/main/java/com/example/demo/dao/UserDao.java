package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User;

@Mapper
public interface UserDao {

	
	
	
	@Select("select * from user")
	List<User> search();
	
	
	@Insert("insert into user values(#{id},#{userName},#{password})")
	int add(User u);

	@Select("select * from user where id=#{id}")
	User getUserById(@Param("id") String id);

	@Update("update user set userName = #{userName} , password=#{password} where"
			+ " id=#{id}")
	void saveUser(User user);
	
	
	
	
}
