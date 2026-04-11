package com.kh.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.exception.ExistIdException;
import com.kh.exception.ExistNumberException;
import com.kh.model.dto.UserDto;
import com.kh.model.vo.User;

public class UserService {
	
	List<User>users = new ArrayList<>();
	
	public User login(String id, String pw) {
		if(!users.isEmpty()) {
			for(User user :users) {
				if(user.getUserId().equals(id) && user.getUserPw().equals(pw)) {
					return user;
				}
			}
		}
		return null;
	}
	
	public User createUser(UserDto dto) {
		boolean available = availableUser(dto.getUserNo(),dto.getUserId());
		if(available) {
			User user = new User(dto.getUserNo(), dto.getUserId(), dto.getUserPw(), dto.getUserName());
			if(user != null) {
				users.add(user);
				return user;
			}
		}
		return null;
	}
	
	private boolean availableUser(int num, String id) {

		if(!users.isEmpty()) {
			for(User user: users) {
				if(user.getUserId().equals(id)) {
					throw new ExistIdException();
				}
				if(user.getUserNo()==num) {
					throw new ExistNumberException();
				}
			}
			return true;
		}
		return true;
	}
	

	
	
}
