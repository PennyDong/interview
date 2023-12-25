package com.example.backed.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backed.vo.Chat;


public interface chatService {
	
	//create
	Integer add(Chat c);
	
	//read
	List<Chat> chatList();
	
}
