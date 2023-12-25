package com.example.backed.service;

import java.util.List;

import com.example.backed.vo.User;

public interface userService {
	
	
	//create
	Integer add(User u);
	
	//read
	
	List<User> userList();
	User queryUser(String username,String password);
	boolean queryUsername(String username);
	
	//update
	void updateName(String name,String email);
	void updatePassword(String password,String email);
	void updateEmail(String email,String username,String password);
}
