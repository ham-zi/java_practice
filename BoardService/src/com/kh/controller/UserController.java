package com.kh.controller;

import com.kh.model.dto.UserDto;

import com.kh.model.service.UserService;
import com.kh.model.vo.User;

public class UserController {
	UserService ls = new UserService(); 
	
	public User login(String id, String pw) {
		return ls.login(id, pw);
	}
	
	public User createUser(UserDto dto) {
		return ls.createUser(dto);
	}
	
}
