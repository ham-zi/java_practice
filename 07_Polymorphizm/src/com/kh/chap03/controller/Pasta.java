package com.kh.chap03.controller;

public class Pasta extends Cooking{
	
	private void pastaCooking() {
		System.out.println("파스타 요리 시작");
	}
	
	@Override
	public void cooking() {
		pastaCooking();
	}

}
