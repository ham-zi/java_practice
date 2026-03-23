package com.kh.chap03.model.vo;


public class Receipt {
	
	
	private int price;
	private String place;
	private String payment;
	private String date;
	// 날짜를 저장할 수 있는 JDK에서 제공되는 클래스가 있다.
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
	// 생성자 부
	// 메소드 부

	// getter() / setter() / info()
	
	
	public String info() {
		String info = " 상품명 : " +  place
					+ "\n 금액 : " + price
					+ "\n 결제수단 : " +payment
					+ "\n 결제일시 :" + date;
		return info;
	}
	
	

}

