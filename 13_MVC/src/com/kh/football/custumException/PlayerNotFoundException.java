package com.kh.football.custumException;

public class PlayerNotFoundException extends RuntimeException {
	public PlayerNotFoundException(String message) {
		super(message);
	}

}
