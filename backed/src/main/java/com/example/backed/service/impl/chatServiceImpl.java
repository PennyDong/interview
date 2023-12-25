package com.example.backed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backed.service.chatMapper;
import com.example.backed.service.chatService;
import com.example.backed.vo.Chat;

@Service
public class chatServiceImpl implements chatService {

	@Autowired
	chatMapper chatmapper;
	
	@Override
	public Integer add(Chat c) {
		
		chatmapper.add(c);
		
		
		return null;
	}

	@Override
	public List<Chat> chatList() {
		
		List<Chat> cList = chatmapper.chatList();
		
		return cList;
	}

	
}
