package com.kh.model.vo;

import java.util.Objects;

public class User {
	private final int userNo;
	private final String userId;
	private final String userPw;
	private final String userName;
	public User(int userNo, String userId, String userPw, String userName) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
	public int getUserNo() {
		return userNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public String getUserName() {
		return userName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, userNo, userPw);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& userNo == other.userNo && Objects.equals(userPw, other.userPw);
	}
	
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + "]";
	}

	
}
