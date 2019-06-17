package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface UserDao {

	
	
	
	@Select("select * from user")
	List<User> search();

	@CachePut(value="users")
	@Insert("insert into user values(#{id},#{userName},#{password},#{roleId})")
	int add(User u);


	@Cacheable(value="users",key = "#id")
	@Select("select * from user where id=#{id}")
	User getUserById(@Param("id") String id);

	@CacheEvict(value = "users",key="#p0.id")
	@Update("update user set userName = #{userName} , password=#{password} where"
			+ " id=#{id}")
	void saveUser(User user);

	@Select("select * from user where userName=#{username}")
	User getUserByUsername(String username);

	@Select("select * from user where userName=#{userName} and " +
			"password=#{password}")
    User login(User u);
}
