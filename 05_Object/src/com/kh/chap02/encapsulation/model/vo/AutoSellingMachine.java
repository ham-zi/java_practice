package com.kh.chap02.encapsulation.model.vo;

public class AutoSellingMachine { // 단 한개의 제품을 파는 자판기
	//
	//필드 == 멤버변수
	//객체들이 가져야할 공통적인 속성을 기술해 놓는 것
	
	/*
	 * 접근제한자 자료형 필드식별자;
	 * 
	 * 
	 * 주말 숙제: 어떤 분야 개발자 할지 정해오기.
	 */
	
	private String name;
	private int price;
	private int stock;
	private int amount;
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public int getAmount() {
		return amount;
	}
	
	public void insertStock() {
		stock++;
	}
	
	/*
	 * VO -> setter 메소드를 구현하지 않음
	 * DTD -> setter를 구현해서 VO로 다시 구현
	 * 
	 * setter 만들기 규칙
	 * 
	 * 1.setter메소드는 외부에서 접근이 가능해야 하기 때문에 public 
	 * 2. set필드명()으로 식별자를 작성 camelCase를 꼭 지키도록 한다.
	 * 3. 두 개 이상의 필드값을 변경하는 메소드 이름에 set이 붙으면 안됨. (관례위반)
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	// 하나의 메서드는 하나의 기능만을 수행해야한다.
	
	/*
	 * getter 만들기 규칙
	 * 1. public
	 * 2. get필드명(), camelCase 작명법
	 * VO패키지안에 존재하는 클래스라면 getter 필수
	 */
	
	
	// classLoader 클래스를 읽어오는 도구
}
