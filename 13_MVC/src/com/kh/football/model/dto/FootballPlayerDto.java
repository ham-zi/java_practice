package com.kh.football.model.dto;

public class FootballPlayerDto {
	// Data transfer Object
	// 데이터를 전송하는 객체
	// 구성 : 필드, 기본생성자, 매개변수생성자, getter/setter
	// 목적 : 순수하게 데이터를 옮겨담을 용도로 만드는 클래스
	// Dto :  값의 전송 / setterO / 코드 안넣음 / 상황에 따라 record /
	// Vo  :  값을 담음 / setterX / equals(),hashCode(), 비즈니스로직 존재 / final 선언
	//
	private String name;
	private String position;
	private Integer backNumber;
	
	public FootballPlayerDto() {}
	public FootballPlayerDto(String name, String position, Integer backNumber) {
		this.name = name;
		this.position = position;
		this.backNumber = backNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getBackNumber() {
		return backNumber;
	}
	public void setBackNumber(Integer backNumber) {
		this.backNumber = backNumber;
	}

	
	
	
}
