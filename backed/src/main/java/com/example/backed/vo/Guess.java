package com.example.backed.vo;


public class Guess {

	private Integer id;
	private String nickname;
	private String username;
	
	
	
	public Guess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Guess(String nickname, String username) {
		super();
		this.nickname = nickname;
		this.username = username;
	}



	public Guess(Integer id, String nickname, String username) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.username = username;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
