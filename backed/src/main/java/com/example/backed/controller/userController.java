package com.example.backed.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backed.service.impl.userServiceImpl;
import com.example.backed.vo.User;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://127.0.0.1:5500") // 允許來自特定來源的跨來源請求
public class userController {
	public static void main(String[] args) {
		
	}
	
	@Autowired
	userServiceImpl userservice;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String,String> userRequest) {
		
		String username = userRequest.get("username");
		String password = userRequest.get("password");
		
		User checkUser = userservice.queryUser(username, password);
		
		if(checkUser!=null) {
			//登入成功
			Map<String,String> response = new HashMap<>();
			response.put("message", "Login successful");
			return ResponseEntity.ok("{\"message\":\"Login successful\"}");
		}else {
			//登入失敗
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\":\"Login failed\"}");
		}	
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User userRequest) {
		
		
		User userData = new User();
		
		//取得前端發送來的請求Request
		userData.setName(userRequest.getName());
		userData.setUsername(userRequest.getUsername());
		userData.setPassword(userRequest.getPassword());
		userData.setEmail(userRequest.getEmail());
		
		ResponseEntity response=null;
		
		//確認帳號是否重複
		boolean checkUsername = userservice.queryUsername(userData.getUsername());
		//System.out.println(userData);
		if(checkUsername) {
			//帳號重複
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("{\"message\":\"Username already exists\"}");	
		}else {
			
			userservice.add(userData);
			response = ResponseEntity.ok("{\"message\":\"Registration successful\"}");	
		}
		//System.out.println(response);
		return response;
	}
	
}	
	