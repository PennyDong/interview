package com.example.backed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backed.service.impl.chatServiceImpl;
import com.example.backed.vo.Chat;

@RestController
@RequestMapping("/chatbox")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class chatController {
	
	@Autowired
	chatServiceImpl chatservice;
	
	@GetMapping("/chat")
	public ResponseEntity<List<Chat>> chatList() {
		
		
		List<Chat> request_list = chatservice.chatList();
		
		System.out.println(request_list);
		
		return	ResponseEntity.ok(request_list);
	}
	
	@PostMapping("/submitChat")
	public ResponseEntity submitChat(@RequestBody Chat request_chat){
		
		
		Integer id =request_chat.getId();
		String name = request_chat.getName();
		String subject = request_chat.getSubject();
		String content = request_chat.getContent();
		
		Chat chatData = new Chat(id,name,subject,content);
		
		chatservice.add(chatData);
		
		ResponseEntity response = ResponseEntity.ok("{\"message\":\"Message successfully\"}");
		System.out.println(response);
		return response;
	}
}
