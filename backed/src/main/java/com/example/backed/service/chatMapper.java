package com.example.backed.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.backed.vo.Chat;

@Mapper
public interface chatMapper {

	@Insert("insert into chat(name,subject,content)"
			+ "values(#{name},#{subject},#{content})")
	Integer add(Chat c);
	
	@Select("select * from chat order by id desc")
	List<Chat> chatList();
	
}
