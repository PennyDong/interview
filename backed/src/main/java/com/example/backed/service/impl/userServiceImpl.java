package com.example.backed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backed.service.userMapper;
import com.example.backed.service.userService;
import com.example.backed.vo.User;

@Service
public class userServiceImpl implements userService {
	
	
	@Autowired
	userMapper usermapper;
	
	
	@Override
	public Integer add(User u) {
		
		usermapper.add(u);
		
		return null;
		
	}

	@Override
	public List<User> userList() {
		
		List<User> uList = usermapper.userList();
		
		return uList;
	}

	@Override
	public User queryUser(String username, String password) {
		
		User user = usermapper.queryUser(username, password);
		
		return user;
	}

	@Override
	public boolean queryUsername(String username) {
		
		boolean x = false;
		
		User u = usermapper.queryUsername(username);
		
		if(u!=null) {
			x=true;
		}

		return x;
	}

	@Override
	public void updateName(String name, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(String password, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmail(String email, String username, String password) {
		// TODO Auto-generated method stub
		
	}
	
	
}
