package com.example.backed.service;

import java.util.List;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.backed.vo.User;

@Mapper
public interface userMapper {
	
	//create
	@Insert("insert into user(name,username,password,email)"
			+ "values(#{name},#{username},#{password},#{email})")
	Integer add(User u);
	
	//read
	
	@Select("select * from user")
	List<User>userList();
	
	@Select("select * from user where username=#{username} and password=#{password}")
	User queryUser(String username,String password);
	
	@Select("Select * from user where username=#{username}")
	User queryUsername(String username);
	
	//update
	
	@Update("update user set password=#{password} where email=#(email)")
	void updatePassword(String password,String email);
	
	@Update("update user set name=#{name} where email=#{email}")
	void updateName(String name,String email);
	
	@Update("update user set email=#{email} where username=# and password=#{password}")
	void updateEmail(String email,String username,String password);
	
	//delete
	
	
}
